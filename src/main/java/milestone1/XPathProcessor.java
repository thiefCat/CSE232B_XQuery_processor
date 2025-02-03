package milestone1;

import milestone1.autogen.ExpressionParser.XPathParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

/*
    Processes XPath AST on the DOM Tree
 */
public class XPathProcessor {
    public static Document compute(ParseTree ast, Document domTree) throws Exception {
        List<Node> resultNodes = evaluate(ast, domTree.getDocumentElement());

        // Create a new result DOM tree
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element root = doc.createElement("result");
        doc.appendChild(root);

        // Append matching nodes to the new document
        for (Node node : resultNodes) {
            Node importedNode = doc.importNode(node, true);
            root.appendChild(importedNode);
            try {
                Node newNode;
                newNode = doc.importNode(node, true);
                root.appendChild(newNode);
            } catch (DOMException e) {
                if (e.code != DOMException.NOT_SUPPORTED_ERR) {
                    throw e;
                }
            }
        }
        return doc;
    }

    // To DO
    public static List<Node> evaluate(ParseTree ast, Node currentNode) {
        List<Node> result = new ArrayList<>();

        if (ast instanceof XPathParser.AbsolutePathContext) {
            return evaluate(ast.getChild(1), currentNode);
        }

        if (ast instanceof XPathParser.TagNameContext) {
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

        return null;
    }
}
