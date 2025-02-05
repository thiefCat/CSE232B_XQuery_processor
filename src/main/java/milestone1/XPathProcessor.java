package milestone1;

import milestone1.autogen.ExpressionParser.XPathParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

/*
    Processes XPath AST on the DOM Tree
*/

public class XPathProcessor {
    public static Document compute(ParseTree ast, Document domTree) throws Exception {
        List<Node> resultNodes = evaluate(ast, domTree.getDocumentElement());

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

        if (ast instanceof XPathParser.ChildrenRPContext) {
            List<Node> results = handleChildrenRP(ast, currentNode);
            List<Node> uniqueResults = new ArrayList<>(new LinkedHashSet<>(results));
            return uniqueResults;
        }

        // Terminal Node
        if (ast instanceof XPathParser.TagRPContext) {
            return handleTagRP(ast, currentNode);
        }


        return null;
    }

    private static List<Node> handleChildrenRP(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();
        List<Node> rp1Results = evaluate(ast.getChild(0), currentNode);
        for (Node rp1 : rp1Results) {
            result.addAll(evaluate(ast.getChild(2), rp1));
        }
        return result;
    }

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
}
