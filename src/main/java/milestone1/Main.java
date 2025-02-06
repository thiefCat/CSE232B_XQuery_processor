package milestone1;


import milestone1.autogen.ExpressionParser.XPathLexer;
import milestone1.autogen.ExpressionParser.XPathParser;
import javax.xml.parsers.ParserConfigurationException;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import milestone1.XMLParser.*;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import java.io.OutputStream;
import java.util.List;

import org.w3c.dom.Node;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws Exception {
        String XPathFileName = args[0];
        String OutputFileName = args[1];
        System.out.println("Xpath file path: " + XPathFileName);

        XPathLexer lexer = new XPathLexer(new ANTLRFileStream(XPathFileName));
        XPathParser parser = new XPathParser(new CommonTokenStream(lexer));
        ParseTree ast = parser.absolutePath();

        List<Node> result = XPathProcessor.compute(ast);
        // save to "src/output.xml"

        XMLParser.saveXML(result, OutputFileName);
    }

}
