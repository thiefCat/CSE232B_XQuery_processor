import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import antlr.XPathLexer;
import antlr.XPathParser;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        String xmlFileName = args[0];
        String XPathFileName = args[1];
        String outputFileName = args[2];
        System.out.println("Input XML file path: " + xmlFileName);
        System.out.println("Input Xpath file path: " + XPathFileName);
        System.out.println("Output XML file path: " + outputFileName);

        XPathLexer lexer = new XPathLexer(new ANTLRFileStream(XPathFileName));
        XPathParser parser = new XPathParser(new CommonTokenStream(lexer));
        ParseTree ast = parser.absolutePath();

        Document document = XMLParser.loadXML(xmlFileName);
        Document resDocument = XPathProcessor.compute(document, ast);
        // save to "src/output.xml"

        XMLParser.saveXML(resDocument, outputFileName);
        System.out.println("Output file successfully generated at " + args[2]);
    }

}
