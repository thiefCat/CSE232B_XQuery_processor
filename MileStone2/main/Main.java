import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import antlr.XQueryLexer;
import antlr.XQueryParser;

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

        // parse XQuery into tree
        XQueryLexer lexer = new XQueryLexer(new ANTLRFileStream(XPathFileName));
        XQueryParser parser = new XQueryParser(new CommonTokenStream(lexer));
        ParseTree ast = parser.xquery();

        // parse input xml into tree
        Document document = XMLParser.loadXML(xmlFileName);
        Document resDocument = XQueryProcessor.compute(document, ast);

        // save to "outputFileName"
        XMLParser.saveXML(resDocument, outputFileName);
        System.out.println("Output file successfully generated at " + args[2]);
    }
}
