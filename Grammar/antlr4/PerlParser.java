// Generated from Perl.g4 by ANTLR 4.5.3
package org.language.perl.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PerlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITESPACE=1, COMMENT=2, COMMANDS=3, SPECIAL_VAR=4, LBRACK=5, RBRACK=6, 
		LPAREN=7, RPAREN=8, LCURLY=9, RCURLY=10, COMMA=11, SEMI_COLON=12, COLON=13, 
		DOT=14, BACKSLASH=15, CARET=16, UNDERSCORE=17, PIPE=18, AMPERSAND=19, 
		EQUAL=20, PLUS=21, MINUS=22, MULTIPLY=23, DIVIDE=24, GT=25, LT=26, SQUOTE=27, 
		DQUOTE=28, SCALAR_VAR=29, ARRAY_VAR=30, HASH_VAR=31, VARIABLE=32, NUMBER=33, 
		CHARACTERS=34, ESCAPE_SEQUENCE=35, STRING=36;
	public static final int
		RULE_prog = 0;
	public static final String[] ruleNames = {
		"prog"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'['", "']'", "'('", "')'", "'{'", "'}'", 
		"','", "';'", "':'", "'.'", "'\\'", "'^'", "'_'", "'|'", "'&'", "'='", 
		"'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'''", "'\"'", "'$'", "'@'", 
		"'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "WHITESPACE", "COMMENT", "COMMANDS", "SPECIAL_VAR", "LBRACK", "RBRACK", 
		"LPAREN", "RPAREN", "LCURLY", "RCURLY", "COMMA", "SEMI_COLON", "COLON", 
		"DOT", "BACKSLASH", "CARET", "UNDERSCORE", "PIPE", "AMPERSAND", "EQUAL", 
		"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "GT", "LT", "SQUOTE", "DQUOTE", 
		"SCALAR_VAR", "ARRAY_VAR", "HASH_VAR", "VARIABLE", "NUMBER", "CHARACTERS", 
		"ESCAPE_SEQUENCE", "STRING"
	};
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
	public String getGrammarFileName() { return "Perl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PerlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PerlParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(5);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(2);
					matchWildcard();
					}
					} 
				}
				setState(7);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(8);
			match(EOF);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\r\4\2\t\2\3\2\7"+
		"\2\6\n\2\f\2\16\2\t\13\2\3\2\3\2\3\2\3\7\2\3\2\2\2\f\2\7\3\2\2\2\4\6\13"+
		"\2\2\2\5\4\3\2\2\2\6\t\3\2\2\2\7\b\3\2\2\2\7\5\3\2\2\2\b\n\3\2\2\2\t\7"+
		"\3\2\2\2\n\13\7\2\2\3\13\3\3\2\2\2\3\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}