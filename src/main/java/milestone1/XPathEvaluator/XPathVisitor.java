package milestone1.XPathEvaluator;
import milestone1.autogen.ExpressionParser.XPathParser;
import org.w3c.dom.Node;
import java.util.List;
import milestone1.autogen.ExpressionParser.XPathBaseVisitor;

public class XPathVisitor extends XPathBaseVisitor<List<Node>>{
    /* TODO:
     * Get list of nodes from doc filename
     */
    @Override
    public List<Node> visitDoc(XPathParser.DocContext ctx){

    }

    /* TODO:
     *  implement visit for all fields after the hashtag'#' in XPath.g4
     */

}
