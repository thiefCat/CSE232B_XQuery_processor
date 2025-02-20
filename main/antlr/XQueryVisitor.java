// Generated from main/antlr/XQuery.g4 by ANTLR 4.13.2

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XQueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XQueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code letXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetXQuery(XQueryParser.LetXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code scXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScXQuery(XQueryParser.ScXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tagXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagXQuery(XQueryParser.TagXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleSlashXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleSlashXQuery(XQueryParser.DoubleSlashXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaXQuery(XQueryParser.CommaXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code flwrXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlwrXQuery(XQueryParser.FlwrXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code braceXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBraceXQuery(XQueryParser.BraceXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleSlashXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleSlashXQuery(XQueryParser.SingleSlashXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarXQuery(XQueryParser.VarXQueryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code apXQuery}
	 * labeled alternative in {@link XQueryParser#xquery}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApXQuery(XQueryParser.ApXQueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#forClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClause(XQueryParser.ForClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#letClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetClause(XQueryParser.LetClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#whereClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhereClause(XQueryParser.WhereClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#returnClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnClause(XQueryParser.ReturnClauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrCondition(XQueryParser.OrConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndCondition(XQueryParser.AndConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesizedCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedCondition(XQueryParser.ParenthesizedConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsCondition(XQueryParser.IsConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCondition(XQueryParser.NotConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyCondition(XQueryParser.EmptyConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code satisfyCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSatisfyCondition(XQueryParser.SatisfyConditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqCondition}
	 * labeled alternative in {@link XQueryParser#queryCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqCondition(XQueryParser.EqConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#beginTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginTag(XQueryParser.BeginTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#endTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndTag(XQueryParser.EndTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(XQueryParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code childAP}
	 * labeled alternative in {@link XQueryParser#absolutePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildAP(XQueryParser.ChildAPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code descendantAP}
	 * labeled alternative in {@link XQueryParser#absolutePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantAP(XQueryParser.DescendantAPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code allChildrenRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAllChildrenRP(XQueryParser.AllChildrenRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code textRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextRP(XQueryParser.TextRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parentRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentRP(XQueryParser.ParentRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code selfRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelfRP(XQueryParser.SelfRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code filterRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterRP(XQueryParser.FilterRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commaRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommaRP(XQueryParser.CommaRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code childrenRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChildrenRP(XQueryParser.ChildrenRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tagRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagRP(XQueryParser.TagRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code descendantRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescendantRP(XQueryParser.DescendantRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code attributeRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeRP(XQueryParser.AttributeRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketRP}
	 * labeled alternative in {@link XQueryParser#relativePath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketRP(XQueryParser.BracketRPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqFilter(XQueryParser.EqFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotFilter(XQueryParser.NotFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndFilter(XQueryParser.AndFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketFilter(XQueryParser.BracketFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsFilter(XQueryParser.IsFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rpFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRpFilter(XQueryParser.RpFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringFilter(XQueryParser.StringFilterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orFilter}
	 * labeled alternative in {@link XQueryParser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrFilter(XQueryParser.OrFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#doc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoc(XQueryParser.DocContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#tagName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagName(XQueryParser.TagNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link XQueryParser#attrName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrName(XQueryParser.AttrNameContext ctx);
}