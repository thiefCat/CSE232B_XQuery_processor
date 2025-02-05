package milestone1;

import milestone1.autogen.ExpressionParser.XPathParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;
import milestone1.XMLParser.*;

/*
    Processes XPath AST on the DOM Tree
*/

public class XPathProcessor {

    private static final String baseAddr = "src/main/resources/";
    public static Document compute(ParseTree ast) throws Exception {
        String xmlFileAddr = baseAddr + ast.getChild(0).getChild(1).getText().replace("\"", "");
        System.out.println("XML File Address: "+xmlFileAddr);
        Document document = XMLParser.loadXML(xmlFileAddr);

        List<Node> resultNodes = evaluate(ast, document.getDocumentElement());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document newDoc = builder.newDocument();
        Element resultRoot = newDoc.createElement("result");
        newDoc.appendChild(resultRoot);

        for (Node node : resultNodes) {
            Node importedNode = newDoc.importNode(node, true);
            resultRoot.appendChild(importedNode);
        }

        return newDoc;
    }

    // To DO
    public static List<Node> evaluate(ParseTree ast, Node currentNode) {
//        System.out.println("Node Name: " + currentNode.getNodeName());
//        System.out.println("Node Type: " + currentNode.getNodeType());
        if (ast instanceof XPathParser.ChildAPContext) {
            return evaluate(ast.getChild(2), currentNode);
        }

        if (ast instanceof XPathParser.DescendantAPContext) {

            return evaluate(ast.getChild(2), currentNode);
        }

       //     | '(' relativePath  ')'    # bracketRP
        if (ast instanceof XPathParser.BracketRPContext) {
            return evaluate(ast.getChild(1), currentNode);
        }
        if (ast instanceof XPathParser.ChildrenRPContext) {
            List<Node> results = handleChildrenRP(ast, currentNode);
            List<Node> uniqueResults = new ArrayList<>(new LinkedHashSet<>(results));
            return uniqueResults;
        }


        if (ast instanceof XPathParser.AllChildrenRPContext) {
            return handleAllChildrenRP(ast, currentNode);
        }

        if (ast instanceof XPathParser.SelfRPContext) {
            return handleSelfRP(ast, currentNode);
        }

        // Terminal Node
        if (ast instanceof XPathParser.TagRPContext) {
            return handleTagRP(ast, currentNode);
        }

        //   | relativePath  '[' f ']'  # filterRP
        if (ast instanceof XPathParser.FilterRPContext) {
            return handleFilterRP(ast, currentNode);
        }

        return null;
    }


    // *
    private static List<Node> handleAllChildrenRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        NodeList children = currentNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                result.add(child);
            }
        }
        return result;
    }

    // .
    private static List<Node> handleSelfRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        result.add(currentNode);
        return result;
    }


    private static boolean evaluateFilter(ParseTree filterNode, Node currentNode) {
        // f   : relativePath         # rpFilter
        if (filterNode instanceof XPathParser.RpFilterContext) {
            return handleRpFilter(filterNode, currentNode);
        }
        //      | relativePath  EQ relativePath   # eqFilter
        // Can't think of a good example, since
        if (filterNode instanceof XPathParser.EqFilterContext) {
            return handleEqFilter(filterNode, currentNode);
        }
        //      | relativePath  IS relativePath   # isFilter
        // doc("test.xml")/breakfast_menu/food[description is description]
        if (filterNode instanceof XPathParser.IsFilterContext) {
            return handleIsFilter(filterNode, currentNode);
        }

        //  | relativePath  '=' STRING # stringFilter
        if (filterNode instanceof XPathParser.StringFilterContext) {
            return handleStringFilter(filterNode, currentNode);
        }

        //    | '(' f ')' # bracketFilter
        if(filterNode instanceof  XPathParser.BracketFilterContext) {
            return handleBracketFilter(filterNode, currentNode);
        }

        //     | f 'and' f # andFilter
        // e.g. doc("test.xml")/breakfast_menu/food[((description)) and name="Belgian Waffles"]
        if(filterNode instanceof  XPathParser.AndFilterContext) {
            return handleAndFilter(filterNode, currentNode);
        }
        //     | f 'or' f  # orFilter
        // e.g. doc("test.xml")/breakfast_menu/food[((not description)) or name="Belgian Waffles"]
        if(filterNode instanceof  XPathParser.OrFilterContext) {
            return handleOrFilter(filterNode, currentNode);
        }

        //     | 'not' f   # notFilter
        if (filterNode instanceof XPathParser.NotFilterContext) {
            return handleNotFilter(filterNode, currentNode);
        }
        return false;
    }

    // rp1/rp2
    private static List<Node> handleChildrenRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        List<Node> rp1Results = evaluate(ast.getChild(0), currentNode);
        for (Node rp1 : rp1Results) {
            result.addAll(evaluate(ast.getChild(2), rp1));
        }
        return result;
    }

    // tagName
    private static List<Node> handleTagRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        String tagName = ast.getText();
        NodeList children = currentNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals(tagName)) {
                result.add(child);
            }
        }
        return result;
    }
    // [[rp[f]]]R(n)
    // = < x | x ← [[rp]]R(n), [[f]]F (x)
    private static List<Node> handleFilterRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        List<Node> potentialXList = evaluate(ast.getChild(0), currentNode);
        // The filter expression is at child index 2 in the parse tree.
        ParseTree filterAST = ast.getChild(2);

        for (Node x : potentialXList) {
            // Check if filter evaluates to true for this node.
            if (evaluateFilter(filterAST, x)) {
                result.add(x);
            }
        }

        return result;
    }

    private static boolean handleRpFilter(ParseTree ast, Node currentNode) {
        // [[rp]]F (n)
        // = [[rp]]R(n) !=   <>       (14)
        List<Node> rpResults = evaluate(ast.getChild(0), currentNode);
        return rpResults != null && !rpResults.isEmpty();
    }

    private static boolean handleEqFilter(ParseTree ast, Node currentNode) {
        List<Node> rpResults0 = evaluate(ast.getChild(0), currentNode);
        List<Node> rpResults1 = evaluate(ast.getChild(2), currentNode);
        for (Node node1 : rpResults0) {
            for (Node node2 : rpResults1) {
                if (node1.isEqualNode(node2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean handleIsFilter(ParseTree ast, Node currentNode) {
        List<Node> rpResults0 = evaluate(ast.getChild(0), currentNode);
        List<Node> rpResults1 = evaluate(ast.getChild(2), currentNode);
        for (Node node1 : rpResults0) {
            for (Node node2 : rpResults1) {
                if (node1.isSameNode(node2)) {
                    return true;
                }
            }
        }
        return false;
    }

    // [[rp = StringConstant]]F (n)
    // = ∃x ∈ [[rp]]R(n) x eq StringConstant (17)
    private static boolean handleStringFilter(ParseTree ast, Node currentNode) {
        // Extract and normalize the string literal (remove surrounding quotes).
        String stringConstant = ast.getChild(2).getText();
        if (stringConstant.length() >= 2) {
            stringConstant = stringConstant.substring(1, stringConstant.length() - 1);
        }

        // Evaluate the relativePath (child index 0) against currentNode.
        // This is a placeholder; assume there's a method to do this.
        List<Node> resultNodes = evaluate(ast.getChild(0), currentNode);

        // Check if any node's string value matches targetString.
        for (Node node : resultNodes) {
            if (node.getTextContent().equals(stringConstant)) {
                return true;
            }
        }
        // No match, return false
        return false;
    }

    private static boolean handleBracketFilter(ParseTree ast, Node currentNode) {
        // [[(f)]]F (n)
        // = [[f]]F (n) (18)
        //
        return evaluateFilter(ast.getChild(1), currentNode);
    }

    private static boolean handleAndFilter(ParseTree ast, Node currentNode) {
        // [[f1 and f2]]F (n) = [[f1]]F (n) ∧ [[f2]]F (n) (19)
        return evaluateFilter(ast.getChild(0), currentNode) && evaluateFilter(ast.getChild(2), currentNode);
    }

    private static boolean handleOrFilter(ParseTree ast, Node currentNode) {
        // [[f1 and f2]]F (n) = [[f1]]F (n) ∨ [[f2]]F (n) (19)
        return evaluateFilter(ast.getChild(0), currentNode) || evaluateFilter(ast.getChild(2), currentNode);
    }

    private static boolean handleNotFilter(ParseTree ast, Node currentNode) {
        // [[not f]]F (n)
        //  = ¬[[f]]F (n) (21)
        return !evaluateFilter(ast.getChild(1), currentNode);
    }


}
