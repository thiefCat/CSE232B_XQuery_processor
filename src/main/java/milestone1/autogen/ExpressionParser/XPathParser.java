// Generated from XPath.g4 by ANTLR 4.13.2

    package milestone1.autogen.ExpressionParser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		EQ=18, IS=19, ID=20, FILENAME=21, WHITESPACE=22, STRING=23, ESCAPE=24;
	public static final int
		RULE_absolutePath = 0, RULE_relativePath = 1, RULE_f = 2, RULE_doc = 3, 
		RULE_tagName = 4, RULE_attrName = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"absolutePath", "relativePath", "f", "doc", "tagName", "attrName"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'//'", "'*'", "'.'", "'..'", "'text()'", "'@'", "'('", 
			"')'", "'['", "']'", "','", "'='", "'and'", "'or'", "'not'", "'doc('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "EQ", "IS", "ID", "FILENAME", "WHITESPACE", 
			"STRING", "ESCAPE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AbsolutePathContext extends ParserRuleContext {
		public AbsolutePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_absolutePath; }
	 
		public AbsolutePathContext() { }
		public void copyFrom(AbsolutePathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChildAPContext extends AbsolutePathContext {
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public ChildAPContext(AbsolutePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterChildAP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitChildAP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitChildAP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DescendantAPContext extends AbsolutePathContext {
		public DocContext doc() {
			return getRuleContext(DocContext.class,0);
		}
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public DescendantAPContext(AbsolutePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterDescendantAP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitDescendantAP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitDescendantAP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AbsolutePathContext absolutePath() throws RecognitionException {
		AbsolutePathContext _localctx = new AbsolutePathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_absolutePath);
		try {
			setState(20);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				_localctx = new ChildAPContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(12);
				doc();
				setState(13);
				match(T__0);
				setState(14);
				relativePath(0);
				}
				break;
			case 2:
				_localctx = new DescendantAPContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(16);
				doc();
				setState(17);
				match(T__1);
				setState(18);
				relativePath(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RelativePathContext extends ParserRuleContext {
		public RelativePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relativePath; }
	 
		public RelativePathContext() { }
		public void copyFrom(RelativePathContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AllChildrenRPContext extends RelativePathContext {
		public AllChildrenRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAllChildrenRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAllChildrenRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAllChildrenRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextRPContext extends RelativePathContext {
		public TextRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTextRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTextRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitTextRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentRPContext extends RelativePathContext {
		public ParentRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterParentRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitParentRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitParentRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfRPContext extends RelativePathContext {
		public SelfRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterSelfRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitSelfRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitSelfRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FilterRPContext extends RelativePathContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FilterRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterFilterRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitFilterRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitFilterRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CommaRPContext extends RelativePathContext {
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public CommaRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterCommaRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitCommaRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitCommaRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChildrenRPContext extends RelativePathContext {
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public ChildrenRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterChildrenRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitChildrenRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitChildrenRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagRPContext extends RelativePathContext {
		public TagNameContext tagName() {
			return getRuleContext(TagNameContext.class,0);
		}
		public TagRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTagRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTagRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitTagRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DescendantRPContext extends RelativePathContext {
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public DescendantRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterDescendantRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitDescendantRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitDescendantRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttributeRPContext extends RelativePathContext {
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public AttributeRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAttributeRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAttributeRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAttributeRP(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketRPContext extends RelativePathContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public BracketRPContext(RelativePathContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterBracketRP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitBracketRP(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitBracketRP(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelativePathContext relativePath() throws RecognitionException {
		return relativePath(0);
	}

	private RelativePathContext relativePath(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelativePathContext _localctx = new RelativePathContext(_ctx, _parentState);
		RelativePathContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_relativePath, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new TagRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(23);
				tagName();
				}
				break;
			case T__2:
				{
				_localctx = new AllChildrenRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24);
				match(T__2);
				}
				break;
			case T__3:
				{
				_localctx = new SelfRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(T__3);
				}
				break;
			case T__4:
				{
				_localctx = new ParentRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__4);
				}
				break;
			case T__5:
				{
				_localctx = new TextRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(T__5);
				}
				break;
			case T__6:
				{
				_localctx = new AttributeRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28);
				match(T__6);
				setState(29);
				attrName();
				}
				break;
			case T__7:
				{
				_localctx = new BracketRPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(T__7);
				setState(31);
				relativePath(0);
				setState(32);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(50);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
					case 1:
						{
						_localctx = new ChildrenRPContext(new RelativePathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(36);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(37);
						match(T__0);
						setState(38);
						relativePath(5);
						}
						break;
					case 2:
						{
						_localctx = new DescendantRPContext(new RelativePathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(39);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(40);
						match(T__1);
						setState(41);
						relativePath(4);
						}
						break;
					case 3:
						{
						_localctx = new CommaRPContext(new RelativePathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(42);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(43);
						match(T__11);
						setState(44);
						relativePath(2);
						}
						break;
					case 4:
						{
						_localctx = new FilterRPContext(new RelativePathContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_relativePath);
						setState(45);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(46);
						match(T__9);
						setState(47);
						f(0);
						setState(48);
						match(T__10);
						}
						break;
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FContext extends ParserRuleContext {
		public FContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_f; }
	 
		public FContext() { }
		public void copyFrom(FContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqFilterContext extends FContext {
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public TerminalNode EQ() { return getToken(XPathParser.EQ, 0); }
		public EqFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterEqFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitEqFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitEqFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public NotFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterNotFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitNotFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitNotFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public AndFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAndFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAndFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAndFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BracketFilterContext extends FContext {
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public BracketFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterBracketFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitBracketFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitBracketFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsFilterContext extends FContext {
		public List<RelativePathContext> relativePath() {
			return getRuleContexts(RelativePathContext.class);
		}
		public RelativePathContext relativePath(int i) {
			return getRuleContext(RelativePathContext.class,i);
		}
		public TerminalNode IS() { return getToken(XPathParser.IS, 0); }
		public IsFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterIsFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitIsFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitIsFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RpFilterContext extends FContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public RpFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterRpFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitRpFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitRpFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringFilterContext extends FContext {
		public RelativePathContext relativePath() {
			return getRuleContext(RelativePathContext.class,0);
		}
		public TerminalNode STRING() { return getToken(XPathParser.STRING, 0); }
		public StringFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterStringFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitStringFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitStringFilter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrFilterContext extends FContext {
		public List<FContext> f() {
			return getRuleContexts(FContext.class);
		}
		public FContext f(int i) {
			return getRuleContext(FContext.class,i);
		}
		public OrFilterContext(FContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterOrFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitOrFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitOrFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f() throws RecognitionException {
		return f(0);
	}

	private FContext f(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FContext _localctx = new FContext(_ctx, _parentState);
		FContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_f, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				_localctx = new RpFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(56);
				relativePath(0);
				}
				break;
			case 2:
				{
				_localctx = new EqFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				relativePath(0);
				setState(58);
				match(EQ);
				setState(59);
				relativePath(0);
				}
				break;
			case 3:
				{
				_localctx = new IsFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				relativePath(0);
				setState(62);
				match(IS);
				setState(63);
				relativePath(0);
				}
				break;
			case 4:
				{
				_localctx = new StringFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				relativePath(0);
				setState(66);
				match(T__12);
				setState(67);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new BracketFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(T__7);
				setState(70);
				f(0);
				setState(71);
				match(T__8);
				}
				break;
			case 6:
				{
				_localctx = new NotFilterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(T__15);
				setState(74);
				f(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(85);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(83);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new AndFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(77);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(78);
						match(T__13);
						setState(79);
						f(4);
						}
						break;
					case 2:
						{
						_localctx = new OrFilterContext(new FContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_f);
						setState(80);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(81);
						match(T__14);
						setState(82);
						f(3);
						}
						break;
					}
					} 
				}
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocContext extends ParserRuleContext {
		public TerminalNode FILENAME() { return getToken(XPathParser.FILENAME, 0); }
		public DocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterDoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitDoc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitDoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocContext doc() throws RecognitionException {
		DocContext _localctx = new DocContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_doc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__16);
			setState(89);
			match(FILENAME);
			setState(90);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XPathParser.ID, 0); }
		public TagNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterTagName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitTagName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitTagName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagNameContext tagName() throws RecognitionException {
		TagNameContext _localctx = new TagNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tagName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(XPathParser.ID, 0); }
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XPathListener ) ((XPathListener)listener).exitAttrName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof XPathVisitor ) return ((XPathVisitor<? extends T>)visitor).visitAttrName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_attrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return relativePath_sempred((RelativePathContext)_localctx, predIndex);
		case 2:
			return f_sempred((FContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean relativePath_sempred(RelativePathContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean f_sempred(FContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0015\b\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001#\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00013\b\u0001\n\u0001"+
		"\f\u00016\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002L\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005"+
		"\u0002T\b\u0002\n\u0002\f\u0002W\t\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0000\u0002\u0002\u0004\u0006\u0000\u0002\u0004\u0006\b\n\u0000"+
		"\u0000l\u0000\u0014\u0001\u0000\u0000\u0000\u0002\"\u0001\u0000\u0000"+
		"\u0000\u0004K\u0001\u0000\u0000\u0000\u0006X\u0001\u0000\u0000\u0000\b"+
		"\\\u0001\u0000\u0000\u0000\n^\u0001\u0000\u0000\u0000\f\r\u0003\u0006"+
		"\u0003\u0000\r\u000e\u0005\u0001\u0000\u0000\u000e\u000f\u0003\u0002\u0001"+
		"\u0000\u000f\u0015\u0001\u0000\u0000\u0000\u0010\u0011\u0003\u0006\u0003"+
		"\u0000\u0011\u0012\u0005\u0002\u0000\u0000\u0012\u0013\u0003\u0002\u0001"+
		"\u0000\u0013\u0015\u0001\u0000\u0000\u0000\u0014\f\u0001\u0000\u0000\u0000"+
		"\u0014\u0010\u0001\u0000\u0000\u0000\u0015\u0001\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0006\u0001\uffff\uffff\u0000\u0017#\u0003\b\u0004\u0000"+
		"\u0018#\u0005\u0003\u0000\u0000\u0019#\u0005\u0004\u0000\u0000\u001a#"+
		"\u0005\u0005\u0000\u0000\u001b#\u0005\u0006\u0000\u0000\u001c\u001d\u0005"+
		"\u0007\u0000\u0000\u001d#\u0003\n\u0005\u0000\u001e\u001f\u0005\b\u0000"+
		"\u0000\u001f \u0003\u0002\u0001\u0000 !\u0005\t\u0000\u0000!#\u0001\u0000"+
		"\u0000\u0000\"\u0016\u0001\u0000\u0000\u0000\"\u0018\u0001\u0000\u0000"+
		"\u0000\"\u0019\u0001\u0000\u0000\u0000\"\u001a\u0001\u0000\u0000\u0000"+
		"\"\u001b\u0001\u0000\u0000\u0000\"\u001c\u0001\u0000\u0000\u0000\"\u001e"+
		"\u0001\u0000\u0000\u0000#4\u0001\u0000\u0000\u0000$%\n\u0004\u0000\u0000"+
		"%&\u0005\u0001\u0000\u0000&3\u0003\u0002\u0001\u0005\'(\n\u0003\u0000"+
		"\u0000()\u0005\u0002\u0000\u0000)3\u0003\u0002\u0001\u0004*+\n\u0001\u0000"+
		"\u0000+,\u0005\f\u0000\u0000,3\u0003\u0002\u0001\u0002-.\n\u0002\u0000"+
		"\u0000./\u0005\n\u0000\u0000/0\u0003\u0004\u0002\u000001\u0005\u000b\u0000"+
		"\u000013\u0001\u0000\u0000\u00002$\u0001\u0000\u0000\u00002\'\u0001\u0000"+
		"\u0000\u00002*\u0001\u0000\u0000\u00002-\u0001\u0000\u0000\u000036\u0001"+
		"\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"5\u0003\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0006\u0002"+
		"\uffff\uffff\u00008L\u0003\u0002\u0001\u00009:\u0003\u0002\u0001\u0000"+
		":;\u0005\u0012\u0000\u0000;<\u0003\u0002\u0001\u0000<L\u0001\u0000\u0000"+
		"\u0000=>\u0003\u0002\u0001\u0000>?\u0005\u0013\u0000\u0000?@\u0003\u0002"+
		"\u0001\u0000@L\u0001\u0000\u0000\u0000AB\u0003\u0002\u0001\u0000BC\u0005"+
		"\r\u0000\u0000CD\u0005\u0017\u0000\u0000DL\u0001\u0000\u0000\u0000EF\u0005"+
		"\b\u0000\u0000FG\u0003\u0004\u0002\u0000GH\u0005\t\u0000\u0000HL\u0001"+
		"\u0000\u0000\u0000IJ\u0005\u0010\u0000\u0000JL\u0003\u0004\u0002\u0001"+
		"K7\u0001\u0000\u0000\u0000K9\u0001\u0000\u0000\u0000K=\u0001\u0000\u0000"+
		"\u0000KA\u0001\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000KI\u0001\u0000"+
		"\u0000\u0000LU\u0001\u0000\u0000\u0000MN\n\u0003\u0000\u0000NO\u0005\u000e"+
		"\u0000\u0000OT\u0003\u0004\u0002\u0004PQ\n\u0002\u0000\u0000QR\u0005\u000f"+
		"\u0000\u0000RT\u0003\u0004\u0002\u0003SM\u0001\u0000\u0000\u0000SP\u0001"+
		"\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000V\u0005\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000XY\u0005\u0011\u0000\u0000YZ\u0005\u0015\u0000\u0000Z[\u0005"+
		"\t\u0000\u0000[\u0007\u0001\u0000\u0000\u0000\\]\u0005\u0014\u0000\u0000"+
		"]\t\u0001\u0000\u0000\u0000^_\u0005\u0014\u0000\u0000_\u000b\u0001\u0000"+
		"\u0000\u0000\u0007\u0014\"24KSU";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}