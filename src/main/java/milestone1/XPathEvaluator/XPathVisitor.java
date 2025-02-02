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

    // Begin: Absolute Path
    // doc '/' relativePath     # childAP
    @Override
    public List<Node> visitChildAP(XPathParser.ChildAPContext ctx) {

    }

    // doc '//' relativePath    # descendantAP
    @Override
	public List<Node> visitDescendantAP(XPathParser.DescendantAPContext ctx) {

    }
    // End: Absolute Path

    // Begin: RelativePath
    //  tagName       # tagRP
    @Override public List<Node> visitTagRP(XPathParser.TagRPContext ctx) {
    }

    // '*'           # allChildrenRP
    @Override public List<Node>  visitAllChildrenRP(XPathParser.AllChildrenRPContext ctx) {

    }

    // '.'           # selfRP
    @Override public List<Node> visitSelfRP(XPathParser.SelfRPContext ctx) {
    }

    // '..'          # parentRP
    @Override public List<Node>  visitParentRP(XPathParser.ParentRPContext ctx) {
    }

    // 'text()'      # textRP
    @Override public List<Node> visitTextRP(XPathParser.TextRPContext ctx) {
    }

    // '@' attrName  # attributeRP
    @Override public List<Node> visitAttributeRP(XPathParser.AttributeRPContext ctx) {
    }

    // '(' relativePath  ')'    # bracketRP
    @Override public List<Node> visitBracketRP(XPathParser.BracketRPContext ctx) {
    }

    // relativePath  '/' relativePath      # childrenRP
    @Override public List<Node> visitChildrenRP(XPathParser.ChildrenRPContext ctx) {
    }

    // relativePath  '//' relativePath     # descendantRP
    @Override public List<Node> visitDescendantRP(XPathParser.DescendantRPContext ctx) {
    }
    // relativePath  '[' f ']'  # filterRP
    @Override public List<Node> visitFilterRP(XPathParser.FilterRPContext ctx) {
    }

    // relativePath  ',' relativePath      # commaRP
    @Override public List<Node> visitCommaRP(XPathParser.CommaRPContext ctx) {
    }
    // End: RelativePath

    // Begin: Filter
    // f   : relativePath         # rpFilter
    @Override public List<Node>  visitRpFilter(XPathParser.RpFilterContext ctx) {
    }
    // | relativePath  EQ relativePath   # eqFilter
    @Override public List<Node> visitEqFilter(XPathParser.EqFilterContext ctx) {
    }

    // | relativePath  IS relativePath   # isFilter
    @Override public List<Node> visitIsFilter(XPathParser.IsFilterContext ctx) {
    }
    // TODO: | relativePath  '=' STRING # stringFilter
    @Override public List<Node> visitStringFilter(XPathParser.StringFilterContext ctx) {
    }
    //| '(' f ')' # bracketFilter
    @Override public List<Node>  visitBracketFilter(XPathParser.BracketFilterContext ctx) {
    }
    // | f 'and' f # andFilter
    @Override public List<Node>  visitAndFilter(XPathParser.AndFilterContext ctx) {
    }
    // | f 'or' f  # orFilter
    @Override public List<Node>  visitOrFilter(XPathParser.OrFilterContext ctx) {
    }
    // | 'not' f   # notFilter
    @Override public List<Node>  visitNotFilter(XPathParser.NotFilterContext ctx) {
    }
    // End: Filter

}
