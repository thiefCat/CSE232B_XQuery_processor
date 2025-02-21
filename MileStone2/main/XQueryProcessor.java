import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;
import java.util.*;
import antlr.XQueryParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XQueryProcessor {
    static Document tmpDoc = null;

    public static Document compute(Document document, ParseTree ast) throws Exception {
        Map<String, List<Node>> emptyContext = new HashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        tmpDoc = builder.newDocument();

        List<Node> resultNodes = evaluate(ast, document, emptyContext);

        if (resultNodes == null || resultNodes.isEmpty()) {
            return tmpDoc;
        }

        Node root = resultNodes.get(0);
        Node importedRoot = tmpDoc.importNode(root, true);
        tmpDoc.appendChild(importedRoot);

        return tmpDoc;
    }

    public static List<Node> evaluate(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        if (ast instanceof XQueryParser.BraceXQueryContext) {
            return handleBraceXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.TagXQueryContext) {
            return handleTagXQuery(ast, currentNode, context);
        }

        if (ast instanceof XQueryParser.ApXQueryContext) {
            return handleApXQuery(ast, currentNode, context);
        }

        return null;
    }

    private static Element makeElement(String tagName, List<Node> children) {
        try {
            Element newElem = tmpDoc.createElement(tagName);

            for (Node child : children) {
                Node importedChild = tmpDoc.importNode(child, true); // true => deep copy
                newElem.appendChild(importedChild);
            }

            return newElem;

        } catch (Exception e) {
            throw new RuntimeException("Error creating new element for tag: " + tagName, e);
        }
    }

    private static Node makeText(String text){
        try {
            Node newNode = tmpDoc.createTextNode(text);
            return newNode;
        } catch (Exception e) {
            throw new RuntimeException("Error creating new textNode for text: " + text, e);
        }
    }


    private static List<Node> handleBraceXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        List<Node> resultNodes = new ArrayList<>();
        ParseTree insideXQ = ast.getChild(1);
        resultNodes = evaluate(insideXQ, currentNode, context);
        return resultNodes;
    }

    private static List<Node> handleTagXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        List<Node> result = new ArrayList<>();
        String tagName = ast.getChild(0).getChild(1).getText();
        ParseTree insideXQ = ast.getChild(2);
        List<Node> insideNodes = evaluate(insideXQ, currentNode, context);
        result.add(makeElement(tagName, insideNodes));
        return result;
    }

    private static List<Node> handleApXQuery(ParseTree ast, Node currentNode, Map<String, List<Node>> context) {
        ParseTree rpChild = ast.getChild(0);

        return XPathProcessor.evaluate(rpChild, currentNode);
    }

}
