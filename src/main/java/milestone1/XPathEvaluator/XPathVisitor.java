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
        return null;
    }

    /* TODO:
     *  implement visit for all fields after the hashtag'#' in XPath.g4
     */

    // Begin: Absolute Path
    // doc '/' relativePath     # childAP
    @Override
    public List<Node> visitChildAP(XPathParser.ChildAPContext ctx) {
        return null;
    }

    // doc '//' relativePath    # descendantAP
    @Override
	public List<Node> visitDescendantAP(XPathParser.DescendantAPContext ctx) {
        return null;
    }
    // End: Absolute Path

    // Begin: RelativePath
    //  tagName       # tagRP
    @Override public List<Node> visitTagRP(XPathParser.TagRPContext ctx) {
        return null;
    }

    // '*'           # allChildrenRP
    @Override public List<Node>  visitAllChildrenRP(XPathParser.AllChildrenRPContext ctx) {
        return null;
    }

    // '.'           # selfRP
    @Override public List<Node> visitSelfRP(XPathParser.SelfRPContext ctx) {
        return null;
    }

    // '..'          # parentRP
    @Override public List<Node>  visitParentRP(XPathParser.ParentRPContext ctx) {
        return null;
    }

    // 'text()'      # textRP
    @Override public List<Node> visitTextRP(XPathParser.TextRPContext ctx) {
        return null;
    }

    // '@' attrName  # attributeRP
    @Override public List<Node> visitAttributeRP(XPathParser.AttributeRPContext ctx) {
        return null;
    }

    // '(' relativePath  ')'    # bracketRP
    @Override public List<Node> visitBracketRP(XPathParser.BracketRPContext ctx) {
        return null;
    }

    // relativePath  '/' relativePath      # childrenRP
    @Override public List<Node> visitChildrenRP(XPathParser.ChildrenRPContext ctx) {
        return null;
    }

    // relativePath  '//' relativePath     # descendantRP
    @Override public List<Node> visitDescendantRP(XPathParser.DescendantRPContext ctx) {
        return null;
    }
    // relativePath  '[' f ']'  # filterRP
    @Override public List<Node> visitFilterRP(XPathParser.FilterRPContext ctx) {
        return null;
    }

    // relativePath  ',' relativePath      # commaRP
    @Override public List<Node> visitCommaRP(XPathParser.CommaRPContext ctx) {
        return null;
    }
    // End: RelativePath

    // Begin: Filter
    // f   : relativePath         # rpFilter
    @Override public List<Node>  visitRpFilter(XPathParser.RpFilterContext ctx) {
        return null;
    }
    // | relativePath  EQ relativePath   # eqFilter
    @Override public List<Node> visitEqFilter(XPathParser.EqFilterContext ctx) {
        return null;
    }

    // | relativePath  IS relativePath   # isFilter
    @Override public List<Node> visitIsFilter(XPathParser.IsFilterContext ctx) {
        return null;
    }
    // TODO: | relativePath  '=' STRING # stringFilter
    @Override public List<Node> visitStringFilter(XPathParser.StringFilterContext ctx) {
        return null;
    }
    //| '(' f ')' # bracketFilter
    @Override public List<Node>  visitBracketFilter(XPathParser.BracketFilterContext ctx) {
        return null;
    }
    // | f 'and' f # andFilter
    @Override public List<Node>  visitAndFilter(XPathParser.AndFilterContext ctx) {
        return null;
    }
    // | f 'or' f  # orFilter
    @Override public List<Node>  visitOrFilter(XPathParser.OrFilterContext ctx) {
        return null;
    }
    // | 'not' f   # notFilter
    @Override public List<Node>  visitNotFilter(XPathParser.NotFilterContext ctx) {
        return null;
    }
    // End: Filter

}
