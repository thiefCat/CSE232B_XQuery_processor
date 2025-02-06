// Generated from XPath.g4 by ANTLR 4.13.2

    package milestone1.autogen.ExpressionParser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code childAP}
	 * labeled alternative in {@link XPathParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterChildAP(XPathParser.ChildAPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code childAP}
	 * labeled alternative in {@link XPathParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitChildAP(XPathParser.ChildAPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code descendantAP}
	 * labeled alternative in {@link XPathParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterDescendantAP(XPathParser.DescendantAPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendantAP}
	 * labeled alternative in {@link XPathParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitDescendantAP(XPathParser.DescendantAPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allChildrenRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterAllChildrenRP(XPathParser.AllChildrenRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allChildrenRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitAllChildrenRP(XPathParser.AllChildrenRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterTextRP(XPathParser.TextRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitTextRP(XPathParser.TextRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterParentRP(XPathParser.ParentRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitParentRP(XPathParser.ParentRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterSelfRP(XPathParser.SelfRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitSelfRP(XPathParser.SelfRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterFilterRP(XPathParser.FilterRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitFilterRP(XPathParser.FilterRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterCommaRP(XPathParser.CommaRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitCommaRP(XPathParser.CommaRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code childrenRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterChildrenRP(XPathParser.ChildrenRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code childrenRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitChildrenRP(XPathParser.ChildrenRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tagRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterTagRP(XPathParser.TagRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tagRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitTagRP(XPathParser.TagRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code descendantRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterDescendantRP(XPathParser.DescendantRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendantRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitDescendantRP(XPathParser.DescendantRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterAttributeRP(XPathParser.AttributeRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitAttributeRP(XPathParser.AttributeRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterBracketRP(XPathParser.BracketRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketRP}
	 * labeled alternative in {@link XPathParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitBracketRP(XPathParser.BracketRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterEqFilter(XPathParser.EqFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitEqFilter(XPathParser.EqFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XPathParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XPathParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XPathParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XPathParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterBracketFilter(XPathParser.BracketFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitBracketFilter(XPathParser.BracketFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIsFilter(XPathParser.IsFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIsFilter(XPathParser.IsFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XPathParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XPathParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterStringFilter(XPathParser.StringFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitStringFilter(XPathParser.StringFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XPathParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XPathParser#f}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XPathParser.OrFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(XPathParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(XPathParser.DocContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XPathParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XPathParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XPathParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(XPathParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XPathParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(XPathParser.AttrNameContext ctx);
}