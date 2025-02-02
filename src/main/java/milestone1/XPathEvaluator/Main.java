package milestone1.XPathEvaluator;

import java.util.List;

import milestone1.autogen.ExpressionParser.XPathLexer;
import milestone1.autogen.ExpressionParser.XPathParser;
import javax.xml.parsers.ParserConfigurationException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import javax.xml.transform.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import java.io.OutputStream;
import org.w3c.dom.Node;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static TransformerFactory transformerFactory = TransformerFactory.newInstance();

    public static void main(String[] args) throws Exception {
        String fname = args[0];
        XPathLexer lexer = new XPathLexer(new ANTLRFileStream(fname));
        XPathParser parser = new XPathParser(new CommonTokenStream(lexer));
        System.out.println("Test file path: " + fname);
        /* TODO:
         * Call evaluate
         * Call transform
         * Call save_xml
         */
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }

    /* TODO:
     * Construct AST tree,
     * Call visit functions on the tree to evaluate
     */
    public static List<Node> evaluate(String xPathQuery) {

        return null;
    }

    /* Used to generate the final result in xml
     */
    public static Document transform(List<Node> result) throws ParserConfigurationException {
        var dbFactory = DocumentBuilderFactory.newInstance();
        var dBuilder = dbFactory.newDocumentBuilder();
        var doc = dBuilder.newDocument();

        var parentElement = doc.createElement("result");
        doc.appendChild(parentElement);

        for (Node node : result) {
            try {
                Node newNode;
                newNode = doc.importNode(node, true);
                parentElement.appendChild(newNode);
            } catch (DOMException e) {
                if (e.code != DOMException.NOT_SUPPORTED_ERR) {
                    throw e;
                }
            }
        }
        return doc;
    }

    /*
    * Save the Document result to a xml file
    */
    public static void save_xml(Document result, OutputStream outputStream) throws TransformerException {
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        transformer.transform(new DOMSource(result),new StreamResult(outputStream));
    }
}
