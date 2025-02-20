import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;
import java.util.*;
import antlr.XQueryParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/*
    Processes XPath AST on the DOM Tree
*/

public class XPathProcessor {
    public static Document compute(Document document, ParseTree ast) throws Exception {
        List<Node> resultNodes = evaluate(ast, document);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document resultDoc = builder.newDocument();

        // Create the <RESULT> root element
        Element rootElement = resultDoc.createElement("RESULT");
        resultDoc.appendChild(rootElement);

        // Append all result nodes to the <RESULT> element
        for (Node node : resultNodes) {
            Node importedNode = resultDoc.importNode(node, true); // Import node into new document
            rootElement.appendChild(importedNode);
        }

        return resultDoc;
    }

    // To DO
    public static List<Node> evaluate(ParseTree ast, Node currentNode) {
        // [doc(fileName)/rp]_A
        if (ast instanceof XQueryParser.ChildAPContext) {
            return evaluate(ast.getChild(2), currentNode);
        }
        // [doc(fileName)//rp]_A
        if (ast instanceof XQueryParser.DescendantAPContext) {
            return handleDescendantAP(ast, currentNode);
        }

       //     | 'text()'      # textRP
       if (ast instanceof XQueryParser.TextRPContext) {
           return handleTextRP(ast, currentNode);
       }

       //     | '(' relativePath  ')'    # bracketRP
        if (ast instanceof XQueryParser.BracketRPContext) {
            return evaluate(ast.getChild(1), currentNode);
        }

        // [rp1/rp2]_R(n)
        if (ast instanceof XQueryParser.ChildrenRPContext) {
            List<Node> results = handleChildrenRP(ast, currentNode);
            List<Node> uniqueResults = new ArrayList<>(new LinkedHashSet<>(results));
            return uniqueResults;
        }

        // [rp1//rp2]_R(n)
        if (ast instanceof XQueryParser.DescendantRPContext) {
            List<Node> results = handleDescendantRP(ast, currentNode);
            List<Node> uniqueResults = new ArrayList<>(new LinkedHashSet<>(results));
            return uniqueResults;
        }

        // [∗]_R (n)
        if (ast instanceof XQueryParser.AllChildrenRPContext) {
            return handleAllChildrenRP(currentNode);
        }

        // [.]_R (n)
        if (ast instanceof XQueryParser.SelfRPContext) {
            return handleSelfRP(currentNode);
        }

        //     | '..'          # parentRP
        if (ast instanceof XQueryParser.ParentRPContext) {
            return handleParentRP(ast, currentNode);
        }

        // [tagName]R (n)
        if (ast instanceof XQueryParser.TagRPContext) {
            return handleTagRP(ast, currentNode);
        }

        // @attName
        if (ast instanceof XQueryParser.AttributeRPContext) {
            return handleAttributeRP(ast, currentNode);
        }

        // ,
        if (ast instanceof XQueryParser.CommaRPContext) {
            List<Node> leftRes = evaluate(ast.getChild(0), currentNode);
            List<Node> rightRes = evaluate(ast.getChild(2), currentNode);
            Set<Node> uniqueNodes = new LinkedHashSet<>();
            uniqueNodes.addAll(leftRes);
            uniqueNodes.addAll(rightRes);

            return new ArrayList<>(uniqueNodes);
        }

        //   | relativePath  '[' f ']'  # filterRP
        if (ast instanceof XQueryParser.FilterRPContext) {
            return handleFilterRP(ast, currentNode);
        }

        return null;
    }

    // doc//rp -> doc/.//rp
    private static List<Node> handleDescendantAP(ParseTree ast, Node currentNode) {
        XQueryParser.RelativePathContext newCtx = new XQueryParser.RelativePathContext(null, -1);
        XQueryParser.SelfRPContext selfRP = new XQueryParser.SelfRPContext(newCtx);
        XQueryParser.DescendantRPContext descendantRP = new XQueryParser.DescendantRPContext(newCtx);
        descendantRP.addChild(selfRP);
        descendantRP.children.add(ast.getChild(1));
        descendantRP.children.add(ast.getChild(2));
        return evaluate(descendantRP, currentNode);
    }


    // *
    private static List<Node> handleAllChildrenRP(Node currentNode) {
        List<Node> result = new ArrayList<>();
        NodeList children = currentNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            result.add(child);
        }
        return result;
    }

    // text()
    private static List<Node> handleTextRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        NodeList children = currentNode.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.TEXT_NODE) {
                result.add(child);
            }
        }
        return result;
    }

    // .
    private static List<Node> handleSelfRP(Node currentNode) {
        List<Node> result = new ArrayList<>();
        result.add(currentNode);
        return result;
    }

    // ..
    private static List<Node> handleParentRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        Node parent = currentNode.getParentNode();
        if (parent instanceof Document) {
            return result;
        }
        result.add(parent);
        return result;
    }

    // @attrName
    private static List<Node> handleAttributeRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        String targetAttrName = ast.getChild(1).getText();
        NamedNodeMap allAttributes = currentNode.getAttributes();
        for (int j = 0; j < allAttributes.getLength(); j++) {
            Node attr = allAttributes.item(j);
            if (attr.getNodeName().equals(targetAttrName)) {
                result.add(attr);
            }
        }
        return result;
    }


    private static boolean evaluateFilter(ParseTree filterNode, Node currentNode) {
        // f   : relativePath         # rpFilter
        if (filterNode instanceof XQueryParser.RpFilterContext) {
            return handleRpFilter(filterNode, currentNode);
        }
        //      | relativePath  EQ relativePath   # eqFilter
        if (filterNode instanceof XQueryParser.EqFilterContext) {
            return handleEqFilter(filterNode, currentNode);
        }
        //      | relativePath  IS relativePath   # isFilter
        // doc("test.xml")/breakfast_menu/food[description is description]
        if (filterNode instanceof XQueryParser.IsFilterContext) {
            return handleIsFilter(filterNode, currentNode);
        }

        //  | relativePath  '=' STRING # stringFilter
        if (filterNode instanceof XQueryParser.StringFilterContext) {
            return handleStringFilter(filterNode, currentNode);
        }

        //    | '(' f ')' # bracketFilter
        if (filterNode instanceof  XQueryParser.BracketFilterContext) {
            return handleBracketFilter(filterNode, currentNode);
        }

        //     | f 'and' f # andFilter
        // e.g. doc("test.xml")/breakfast_menu/food[((description)) and name="Belgian Waffles"]
        if (filterNode instanceof  XQueryParser.AndFilterContext) {
            return handleAndFilter(filterNode, currentNode);
        }
        //     | f 'or' f  # orFilter
        // e.g. doc("test.xml")/breakfast_menu/food[((not description)) or name="Belgian Waffles"]
        if (filterNode instanceof  XQueryParser.OrFilterContext) {
            return handleOrFilter(filterNode, currentNode);
        }

        //     | 'not' f   # notFilter
        if (filterNode instanceof XQueryParser.NotFilterContext) {
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

    // rp1//rp2 -> rp1/rp2, rp1/*//rp2
    private static List<Node> handleDescendantRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        List<Node> rp1Results = evaluate(ast.getChild(0), currentNode);
        // rp1/rp2
        for (Node n : rp1Results) {
            result.addAll(evaluate(ast.getChild(2), n));
        }
        // rp1/*//rp2
        XQueryParser.RelativePathContext newCtx = new XQueryParser.RelativePathContext(null, -1);
        XQueryParser.AllChildrenRPContext allChildrenRP = new XQueryParser.AllChildrenRPContext(newCtx);
        XQueryParser.DescendantRPContext descendantRP = new XQueryParser.DescendantRPContext(newCtx);
        descendantRP.addChild(allChildrenRP);
        descendantRP.children.add(ast.getChild(1));
        descendantRP.children.add(ast.getChild(2));
        for (Node n : rp1Results) {
            result.addAll(evaluate(descendantRP, n));
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

        List<Node> resultNodes = evaluate(ast.getChild(0), currentNode);

        // Check if any node's string value matches targetString.
        for (Node node : resultNodes) {
            if (node.getTextContent().equals(stringConstant)) {
                return true;
            }
        }
        return false;
    }

    private static boolean handleBracketFilter(ParseTree ast, Node currentNode) {
        // [[(f)]]F (n)
        // = [[f]]F (n) (18)
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
