import org.w3c.dom.*;
import java.util.*;
import antlr.XQueryBaseVisitor;
import antlr.XQueryParser;

public class XQueryVisitor extends XQueryBaseVisitor<List<Node>> {
    private Document tmpDoc;
    private Map<String, List<Node>> contextMap = new HashMap<>();

    public XQueryVisitor(Document doc) {
        this.tmpDoc = doc;
    }

    @Override
    public List<Node> visitXqFLWR(XQueryParser.FlwrXQueryContext ctx) {
        // 1. Evaluate for
        // 2. Evaluate let (optional)
        // 3. Evaluate where
        // 4. Evaluate return
        // Return the resulting List<Node>
        return null;
    }

    @Override
    public List<Node> visitXqVar(XQueryParser.VarXQueryContext ctx) {
        return null;
    }

    @Override
    public List<Node> visitXqConstruct(XQueryParser.TagXQueryContext ctx) {
        return null;
    }

    // And so forth for each grammar rule...
}