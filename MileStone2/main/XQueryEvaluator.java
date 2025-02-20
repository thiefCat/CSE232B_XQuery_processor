import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;
import java.io.*;
import java.io.InputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import antlr.XQueryLexer;
import antlr.XQueryParser;

public class XQueryEvaluator {
    public static List<Node> evaluateXQuery(String XQueryFileName) throws Exception {
        // TODO: NEEDS DOUBLE CHECK
        InputStream xQueryIStream = new FileInputStream(XQueryFileName)
        CharStream cs = CharStreams.fromStream(xQueryIStream);
        XQueryLexer lexer = new XQueryLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);

        // Potentially remove error listeners, set error strategy, etc.

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.newDocument();

        XQueryVisitor visitor = new XQueryVisitor(doc);

        // Start from the root rule (e.g., parser.xquery())
        List<Node> resultNodes = visitor.visit(parser.xquery());
        return resultNodes;
    }
}