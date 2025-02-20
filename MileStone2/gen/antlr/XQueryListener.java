// Generated from /Users/zhaosonglin/Desktop/CSE232B/CSE232B_XQuery_processor/MileStone2/main/antlr/XQuery.g4 by ANTLR 4.13.2
package antlr;

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XQueryParser}.
 */
public interface XQueryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code letXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterLetXQuery(XQueryParser.LetXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitLetXQuery(XQueryParser.LetXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code scXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterScXQuery(XQueryParser.ScXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code scXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitScXQuery(XQueryParser.ScXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tagXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterTagXQuery(XQueryParser.TagXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tagXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitTagXQuery(XQueryParser.TagXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleSlashXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterDoubleSlashXQuery(XQueryParser.DoubleSlashXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleSlashXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitDoubleSlashXQuery(XQueryParser.DoubleSlashXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterCommaXQuery(XQueryParser.CommaXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitCommaXQuery(XQueryParser.CommaXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code flwrXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterFlwrXQuery(XQueryParser.FlwrXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code flwrXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitFlwrXQuery(XQueryParser.FlwrXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code braceXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterBraceXQuery(XQueryParser.BraceXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code braceXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitBraceXQuery(XQueryParser.BraceXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleSlashXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterSingleSlashXQuery(XQueryParser.SingleSlashXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleSlashXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitSingleSlashXQuery(XQueryParser.SingleSlashXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterVarXQuery(XQueryParser.VarXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitVarXQuery(XQueryParser.VarXQueryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code apXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void enterApXQuery(XQueryParser.ApXQueryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code apXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 */
	void exitApXQuery(XQueryParser.ApXQueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void enterForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 */
	void exitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void enterLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 */
	void exitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void enterWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 */
	void exitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void enterReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 */
	void exitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void enterOrCondition(XQueryParser.OrConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void exitOrCondition(XQueryParser.OrConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void enterAndCondition(XQueryParser.AndConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void exitAndCondition(XQueryParser.AndConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesizedCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedCondition(XQueryParser.ParenthesizedConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesizedCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedCondition(XQueryParser.ParenthesizedConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void enterIsCondition(XQueryParser.IsConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void exitIsCondition(XQueryParser.IsConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void enterNotCondition(XQueryParser.NotConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void exitNotCondition(XQueryParser.NotConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void enterEmptyCondition(XQueryParser.EmptyConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void exitEmptyCondition(XQueryParser.EmptyConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code satisfyCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void enterSatisfyCondition(XQueryParser.SatisfyConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code satisfyCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void exitSatisfyCondition(XQueryParser.SatisfyConditionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void enterEqCondition(XQueryParser.EqConditionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 */
	void exitEqCondition(XQueryParser.EqConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#beginTag}.
	 * @param ctx the parse tree
	 */
	void enterBeginTag(XQueryParser.BeginTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#beginTag}.
	 * @param ctx the parse tree
	 */
	void exitBeginTag(XQueryParser.BeginTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 */
	void enterEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 */
	void exitEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(XQueryParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(XQueryParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code childAP}
	 * labeled alternative in {@link XQueryParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterChildAP(XQueryParser.ChildAPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code childAP}
	 * labeled alternative in {@link XQueryParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitChildAP(XQueryParser.ChildAPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code descendantAP}
	 * labeled alternative in {@link XQueryParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void enterDescendantAP(XQueryParser.DescendantAPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendantAP}
	 * labeled alternative in {@link XQueryParser#absolutePath}.
	 * @param ctx the parse tree
	 */
	void exitDescendantAP(XQueryParser.DescendantAPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code allChildrenRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterAllChildrenRP(XQueryParser.AllChildrenRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code allChildrenRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitAllChildrenRP(XQueryParser.AllChildrenRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code textRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterTextRP(XQueryParser.TextRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code textRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitTextRP(XQueryParser.TextRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parentRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterParentRP(XQueryParser.ParentRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parentRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitParentRP(XQueryParser.ParentRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code selfRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterSelfRP(XQueryParser.SelfRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code selfRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitSelfRP(XQueryParser.SelfRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterFilterRP(XQueryParser.FilterRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitFilterRP(XQueryParser.FilterRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterCommaRP(XQueryParser.CommaRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitCommaRP(XQueryParser.CommaRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code childrenRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterChildrenRP(XQueryParser.ChildrenRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code childrenRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitChildrenRP(XQueryParser.ChildrenRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tagRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterTagRP(XQueryParser.TagRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tagRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitTagRP(XQueryParser.TagRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code descendantRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterDescendantRP(XQueryParser.DescendantRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code descendantRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitDescendantRP(XQueryParser.DescendantRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code attributeRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterAttributeRP(XQueryParser.AttributeRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code attributeRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitAttributeRP(XQueryParser.AttributeRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void enterBracketRP(XQueryParser.BracketRPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 */
	void exitBracketRP(XQueryParser.BracketRPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterEqFilter(XQueryParser.EqFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitEqFilter(XQueryParser.EqFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterBracketFilter(XQueryParser.BracketFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitBracketFilter(XQueryParser.BracketFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterIsFilter(XQueryParser.IsFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitIsFilter(XQueryParser.IsFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterStringFilter(XQueryParser.StringFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitStringFilter(XQueryParser.StringFilterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void enterOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 */
	void exitOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 */
	void enterDoc(XQueryParser.DocContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 */
	void exitDoc(XQueryParser.DocContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void enterTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 */
	void exitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link XQueryParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(XQueryParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link XQueryParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(XQueryParser.AttrNameContext ctx);
}