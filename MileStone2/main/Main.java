import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import antlr.XQueryLexer;
import antlr.XQueryParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        String xmlFileName = args[0];
        String XQueryFileName = args[1];
        String outputFileName = args[2];
        System.out.println("Input XML file path: " + xmlFileName);
        System.out.println("Input Xpath file path: " + XQueryFileName);
        System.out.println("Output XML file path: " + outputFileName);

        // CALLING XQueryEvaluator
        List<Node> resultNodes = XQueryEvaluator.evaluateXQuery(XQueryFileName); // return List<Node>

        // BEGIN: Getting resultDoc
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
        // END: Getting resultDoc

        XMLParser.saveXML(resultDoc, outputFileName);
        System.out.println("Output file successfully generated at " + args[2]);
    }
}
