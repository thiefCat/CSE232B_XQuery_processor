package milestone1;

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
import org.antlr.v4.runtime.tree.ParseTree;
import milestone1.XMLParser.*;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import java.io.OutputStream;
import org.w3c.dom.Node;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws Exception {
        String XPathFileName = args[0];
        String xmlFileName = args[1];
        System.out.println("Xpath file path: " + XPathFileName);
        System.out.println("XML file path: " + xmlFileName);


        XPathLexer lexer = new XPathLexer(new ANTLRFileStream(XPathFileName));
        XPathParser parser = new XPathParser(new CommonTokenStream(lexer));
        ParseTree ast = parser.absolutePath();

//        System.out.println("Parsed XPath: " + ast.toStringTree(parser));
        Document document = XMLParser.loadXML(xmlFileName);


        Document resultTree = XPathProcessor.compute(ast, document);
        // save to "src/output.xml"
        XMLParser.saveXML(resultTree, "src/output.xml");
    }

}
