import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;

import java.io.InputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import antlr.XQueryLexer;
import antlr.XQueryParser;

public class XQueryEvaluator {
    public static List<Node> evaluateXQuery(InputStream input) throws Exception {
        // TODO: NEEDS DOUBLE CHECK
        CharStream cs = CharStreams.fromStream(input);
        XQueryLexer lexer = new XQueryLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XQueryParser parser = new XQueryParser(tokens);

        // Potentially remove error listeners, set error strategy, etc.

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.newDocument();

        XQueryVisitor visitor = new XQueryVisitor(doc);

        // Start from the root rule (e.g., parser.xq())
        List<Node> result = visitor.visit(parser.xquery());
        return result;
    }
}