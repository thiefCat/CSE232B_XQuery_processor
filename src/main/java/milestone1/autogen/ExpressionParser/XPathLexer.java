// Generated from XPath.g4 by ANTLR 4.13.2

    package milestone1.autogen.ExpressionParser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class XPathLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		EQ=18, IS=19, ID=20, FILENAME=21, WHITESPACE=22, STRING=23, ESCAPE=24;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"EQ", "IS", "ID", "FILENAME", "WHITESPACE", "STRING", "ESCAPE"
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


	public XPathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0018\u009e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011f\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012l\b\u0012\u0001\u0013\u0004\u0013o\b\u0013\u000b\u0013\f\u0013"+
		"p\u0001\u0014\u0001\u0014\u0004\u0014u\b\u0014\u000b\u0014\f\u0014v\u0001"+
		"\u0014\u0001\u0014\u0004\u0014{\b\u0014\u000b\u0014\f\u0014|\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0004\u0015\u0082\b\u0015\u000b\u0015\f\u0015"+
		"\u0083\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005"+
		"\u0016\u008b\b\u0016\n\u0016\f\u0016\u008e\t\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0005\u0016\u0094\b\u0016\n\u0016\f\u0016\u0097"+
		"\t\u0016\u0001\u0016\u0003\u0016\u009a\b\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0000\u0000\u0018\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013"+
		"\'\u0014)\u0015+\u0016-\u0017/\u0018\u0001\u0000\u0007\u0005\u0000--0"+
		"9AZ__az\u0005\u0000..09AZ__az\u0001\u0000..\u0003\u0000\t\n\r\r  \u0002"+
		"\u0000\"\"\\\\\u0002\u0000\'\'\\\\\u0003\u0000\"\"\'\'\\\\\u00a8\u0000"+
		"\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"+
		"\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"+
		"\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"+
		"\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00011\u0001\u0000\u0000\u0000\u00033\u0001\u0000"+
		"\u0000\u0000\u00056\u0001\u0000\u0000\u0000\u00078\u0001\u0000\u0000\u0000"+
		"\t:\u0001\u0000\u0000\u0000\u000b=\u0001\u0000\u0000\u0000\rD\u0001\u0000"+
		"\u0000\u0000\u000fF\u0001\u0000\u0000\u0000\u0011H\u0001\u0000\u0000\u0000"+
		"\u0013J\u0001\u0000\u0000\u0000\u0015L\u0001\u0000\u0000\u0000\u0017N"+
		"\u0001\u0000\u0000\u0000\u0019P\u0001\u0000\u0000\u0000\u001bR\u0001\u0000"+
		"\u0000\u0000\u001dV\u0001\u0000\u0000\u0000\u001fY\u0001\u0000\u0000\u0000"+
		"!]\u0001\u0000\u0000\u0000#e\u0001\u0000\u0000\u0000%k\u0001\u0000\u0000"+
		"\u0000\'n\u0001\u0000\u0000\u0000)r\u0001\u0000\u0000\u0000+\u0081\u0001"+
		"\u0000\u0000\u0000-\u0099\u0001\u0000\u0000\u0000/\u009b\u0001\u0000\u0000"+
		"\u000012\u0005/\u0000\u00002\u0002\u0001\u0000\u0000\u000034\u0005/\u0000"+
		"\u000045\u0005/\u0000\u00005\u0004\u0001\u0000\u0000\u000067\u0005*\u0000"+
		"\u00007\u0006\u0001\u0000\u0000\u000089\u0005.\u0000\u00009\b\u0001\u0000"+
		"\u0000\u0000:;\u0005.\u0000\u0000;<\u0005.\u0000\u0000<\n\u0001\u0000"+
		"\u0000\u0000=>\u0005t\u0000\u0000>?\u0005e\u0000\u0000?@\u0005x\u0000"+
		"\u0000@A\u0005t\u0000\u0000AB\u0005(\u0000\u0000BC\u0005)\u0000\u0000"+
		"C\f\u0001\u0000\u0000\u0000DE\u0005@\u0000\u0000E\u000e\u0001\u0000\u0000"+
		"\u0000FG\u0005(\u0000\u0000G\u0010\u0001\u0000\u0000\u0000HI\u0005)\u0000"+
		"\u0000I\u0012\u0001\u0000\u0000\u0000JK\u0005[\u0000\u0000K\u0014\u0001"+
		"\u0000\u0000\u0000LM\u0005]\u0000\u0000M\u0016\u0001\u0000\u0000\u0000"+
		"NO\u0005,\u0000\u0000O\u0018\u0001\u0000\u0000\u0000PQ\u0005=\u0000\u0000"+
		"Q\u001a\u0001\u0000\u0000\u0000RS\u0005a\u0000\u0000ST\u0005n\u0000\u0000"+
		"TU\u0005d\u0000\u0000U\u001c\u0001\u0000\u0000\u0000VW\u0005o\u0000\u0000"+
		"WX\u0005r\u0000\u0000X\u001e\u0001\u0000\u0000\u0000YZ\u0005n\u0000\u0000"+
		"Z[\u0005o\u0000\u0000[\\\u0005t\u0000\u0000\\ \u0001\u0000\u0000\u0000"+
		"]^\u0005d\u0000\u0000^_\u0005o\u0000\u0000_`\u0005c\u0000\u0000`a\u0005"+
		"(\u0000\u0000a\"\u0001\u0000\u0000\u0000bf\u0005=\u0000\u0000cd\u0005"+
		"e\u0000\u0000df\u0005q\u0000\u0000eb\u0001\u0000\u0000\u0000ec\u0001\u0000"+
		"\u0000\u0000f$\u0001\u0000\u0000\u0000gh\u0005=\u0000\u0000hl\u0005=\u0000"+
		"\u0000ij\u0005i\u0000\u0000jl\u0005s\u0000\u0000kg\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000l&\u0001\u0000\u0000\u0000mo\u0007\u0000\u0000"+
		"\u0000nm\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pn\u0001\u0000"+
		"\u0000\u0000pq\u0001\u0000\u0000\u0000q(\u0001\u0000\u0000\u0000rt\u0005"+
		"\"\u0000\u0000su\u0007\u0001\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000xz\u0007\u0002\u0000\u0000y{\u0007\u0001\u0000"+
		"\u0000zy\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f"+
		"\u0005\"\u0000\u0000\u007f*\u0001\u0000\u0000\u0000\u0080\u0082\u0007"+
		"\u0003\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001"+
		"\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0086\u0006"+
		"\u0015\u0000\u0000\u0086,\u0001\u0000\u0000\u0000\u0087\u008c\u0005\""+
		"\u0000\u0000\u0088\u008b\u0003/\u0017\u0000\u0089\u008b\b\u0004\u0000"+
		"\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008f\u0001\u0000\u0000"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u009a\u0005\"\u0000\u0000"+
		"\u0090\u0095\u0005\'\u0000\u0000\u0091\u0094\u0003/\u0017\u0000\u0092"+
		"\u0094\b\u0005\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0092"+
		"\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098"+
		"\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u009a"+
		"\u0005\'\u0000\u0000\u0099\u0087\u0001\u0000\u0000\u0000\u0099\u0090\u0001"+
		"\u0000\u0000\u0000\u009a.\u0001\u0000\u0000\u0000\u009b\u009c\u0005\\"+
		"\u0000\u0000\u009c\u009d\u0007\u0006\u0000\u0000\u009d0\u0001\u0000\u0000"+
		"\u0000\f\u0000ekpv|\u0083\u008a\u008c\u0093\u0095\u0099\u0001\u0006\u0000"+
		"\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}