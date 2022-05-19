// Generated from Perl.g4 by ANTLR 4.5
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
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, WHITESPACE=5, COMMENT=6, VARIABLE_SCOPE=7, 
		COMMANDS=8, SPECIAL_VAR=9, LBRACK=10, RBRACK=11, LPAREN=12, RPAREN=13, 
		LCURLY=14, RCURLY=15, COMMA=16, SEMI_COLON=17, COLON=18, DOT=19, BACKSLASH=20, 
		CARET=21, UNDERSCORE=22, PIPE=23, AMPERSAND=24, EQUAL=25, PLUS=26, MINUS=27, 
		MULTIPLY=28, DIVIDE=29, GT=30, LT=31, SQUOTE=32, DQUOTE=33, HASH_LITERAL=34, 
		QUESTIONMARK_LITERAL=35, EXCLAMATION_LITERAL=36, SCALAR_VAR=37, ARRAY_VAR=38, 
		HASH_VAR=39, DIGIT=40, VARIABLE=41, NUMBER=42, CHARACTERS=43, ESCAPE_SEQUENCE=44, 
		STRING=45;
	public static final int
		RULE_prog = 0, RULE_statements = 1, RULE_import_statements = 2, RULE_import_statement = 3, 
		RULE_package_declaration = 4, RULE_print_statement = 5, RULE_use_statement = 6, 
		RULE_require_statement = 7, RULE_variable_declaration = 8, RULE_comment_statements = 9, 
		RULE_comment_statement = 10;
	public static final String[] ruleNames = {
		"prog", "statements", "import_statements", "import_statement", "package_declaration", 
		"print_statement", "use_statement", "require_statement", "variable_declaration", 
		"comment_statements", "comment_statement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'package'", "'print'", "'use'", "'require'", null, null, null, 
		null, null, "'['", "']'", "'('", "')'", "'{'", "'}'", "','", "';'", "':'", 
		"'.'", "'\\'", "'^'", "'_'", "'|'", "'&'", "'='", "'+'", "'-'", "'*'", 
		"'/'", "'>'", "'<'", "'''", "'\"'", "'#'", "'?'", "'!'", "'$'", "'@'", 
		"'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "WHITESPACE", "COMMENT", "VARIABLE_SCOPE", 
		"COMMANDS", "SPECIAL_VAR", "LBRACK", "RBRACK", "LPAREN", "RPAREN", "LCURLY", 
		"RCURLY", "COMMA", "SEMI_COLON", "COLON", "DOT", "BACKSLASH", "CARET", 
		"UNDERSCORE", "PIPE", "AMPERSAND", "EQUAL", "PLUS", "MINUS", "MULTIPLY", 
		"DIVIDE", "GT", "LT", "SQUOTE", "DQUOTE", "HASH_LITERAL", "QUESTIONMARK_LITERAL", 
		"EXCLAMATION_LITERAL", "SCALAR_VAR", "ARRAY_VAR", "HASH_VAR", "DIGIT", 
		"VARIABLE", "NUMBER", "CHARACTERS", "ESCAPE_SEQUENCE", "STRING"
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
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				statements();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << COMMENT) | (1L << VARIABLE_SCOPE) | (1L << LPAREN) | (1L << VARIABLE))) != 0) );
			setState(27);
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

	public static class StatementsContext extends ParserRuleContext {
		public Import_statementsContext import_statements() {
			return getRuleContext(Import_statementsContext.class,0);
		}
		public Comment_statementsContext comment_statements() {
			return getRuleContext(Comment_statementsContext.class,0);
		}
		public Variable_declarationContext variable_declaration() {
			return getRuleContext(Variable_declarationContext.class,0);
		}
		public Print_statementContext print_statement() {
			return getRuleContext(Print_statementContext.class,0);
		}
		public Package_declarationContext package_declaration() {
			return getRuleContext(Package_declarationContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		try {
			setState(34);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				import_statements();
				}
				break;
			case COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				comment_statements();
				}
				break;
			case VARIABLE_SCOPE:
			case LPAREN:
			case VARIABLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(31);
				variable_declaration();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 4);
				{
				setState(32);
				print_statement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 5);
				{
				setState(33);
				package_declaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Import_statementsContext extends ParserRuleContext {
		public List<Import_statementContext> import_statement() {
			return getRuleContexts(Import_statementContext.class);
		}
		public Import_statementContext import_statement(int i) {
			return getRuleContext(Import_statementContext.class,i);
		}
		public Import_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterImport_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitImport_statements(this);
		}
	}

	public final Import_statementsContext import_statements() throws RecognitionException {
		Import_statementsContext _localctx = new Import_statementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_import_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(36);
					import_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(39); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Import_statementContext extends ParserRuleContext {
		public List<Use_statementContext> use_statement() {
			return getRuleContexts(Use_statementContext.class);
		}
		public Use_statementContext use_statement(int i) {
			return getRuleContext(Use_statementContext.class,i);
		}
		public List<Require_statementContext> require_statement() {
			return getRuleContexts(Require_statementContext.class);
		}
		public Require_statementContext require_statement(int i) {
			return getRuleContext(Require_statementContext.class,i);
		}
		public Import_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterImport_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitImport_statement(this);
		}
	}

	public final Import_statementContext import_statement() throws RecognitionException {
		Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_import_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(43);
					switch (_input.LA(1)) {
					case T__2:
						{
						setState(41);
						use_statement();
						}
						break;
					case T__3:
						{
						setState(42);
						require_statement();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(45); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Package_declarationContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(PerlParser.SEMI_COLON, 0); }
		public List<TerminalNode> CHARACTERS() { return getTokens(PerlParser.CHARACTERS); }
		public TerminalNode CHARACTERS(int i) {
			return getToken(PerlParser.CHARACTERS, i);
		}
		public List<TerminalNode> COLON() { return getTokens(PerlParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PerlParser.COLON, i);
		}
		public Package_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_package_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterPackage_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitPackage_declaration(this);
		}
	}

	public final Package_declarationContext package_declaration() throws RecognitionException {
		Package_declarationContext _localctx = new Package_declarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_package_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(T__0);
			{
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				match(CHARACTERS);
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CHARACTERS );
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COLON) {
				{
				{
				setState(53);
				match(COLON);
				setState(54);
				match(COLON);
				{
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(55);
					match(CHARACTERS);
					}
					}
					setState(58); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CHARACTERS );
				}
				}
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(65);
			match(SEMI_COLON);
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

	public static class Print_statementContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE() { return getTokens(PerlParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(PerlParser.VARIABLE, i);
		}
		public List<TerminalNode> SPECIAL_VAR() { return getTokens(PerlParser.SPECIAL_VAR); }
		public TerminalNode SPECIAL_VAR(int i) {
			return getToken(PerlParser.SPECIAL_VAR, i);
		}
		public List<TerminalNode> SEMI_COLON() { return getTokens(PerlParser.SEMI_COLON); }
		public TerminalNode SEMI_COLON(int i) {
			return getToken(PerlParser.SEMI_COLON, i);
		}
		public Print_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterPrint_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitPrint_statement(this);
		}
	}

	public final Print_statementContext print_statement() throws RecognitionException {
		Print_statementContext _localctx = new Print_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_print_statement);
		int _la;
		try {
			setState(106);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(T__1);
				setState(68);
				_la = _input.LA(1);
				if ( !(_la==SPECIAL_VAR || _la==VARIABLE) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(69);
					match(SEMI_COLON);
					}
					}
					setState(72); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SEMI_COLON );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(T__1);
				setState(75);
				match(LPAREN);
				setState(76);
				match(VARIABLE);
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(77);
					match(COMMA);
					setState(78);
					match(VARIABLE);
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				match(RPAREN);
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(85);
					match(SEMI_COLON);
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SEMI_COLON );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				match(T__1);
				setState(91);
				match(LPAREN);
				setState(92);
				match(SPECIAL_VAR);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(93);
					match(COMMA);
					setState(94);
					match(SPECIAL_VAR);
					}
					}
					setState(99);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(100);
				match(RPAREN);
				setState(102); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(101);
					match(SEMI_COLON);
					}
					}
					setState(104); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SEMI_COLON );
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

	public static class Use_statementContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(PerlParser.SEMI_COLON, 0); }
		public List<TerminalNode> CHARACTERS() { return getTokens(PerlParser.CHARACTERS); }
		public TerminalNode CHARACTERS(int i) {
			return getToken(PerlParser.CHARACTERS, i);
		}
		public List<TerminalNode> COLON() { return getTokens(PerlParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PerlParser.COLON, i);
		}
		public TerminalNode STRING() { return getToken(PerlParser.STRING, 0); }
		public Use_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterUse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitUse_statement(this);
		}
	}

	public final Use_statementContext use_statement() throws RecognitionException {
		Use_statementContext _localctx = new Use_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_use_statement);
		int _la;
		try {
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(T__2);
				{
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(109);
					match(CHARACTERS);
					}
					}
					setState(112); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CHARACTERS );
				}
				setState(114);
				match(SEMI_COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(115);
				match(T__2);
				{
				setState(117); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(116);
					match(CHARACTERS);
					}
					}
					setState(119); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CHARACTERS );
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COLON) {
					{
					{
					setState(121);
					match(COLON);
					setState(122);
					match(COLON);
					{
					setState(124); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(123);
						match(CHARACTERS);
						}
						}
						setState(126); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CHARACTERS );
					}
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(133);
				match(SEMI_COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(134);
				match(T__2);
				setState(135);
				match(STRING);
				setState(136);
				match(SEMI_COLON);
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

	public static class Require_statementContext extends ParserRuleContext {
		public TerminalNode SEMI_COLON() { return getToken(PerlParser.SEMI_COLON, 0); }
		public List<TerminalNode> CHARACTERS() { return getTokens(PerlParser.CHARACTERS); }
		public TerminalNode CHARACTERS(int i) {
			return getToken(PerlParser.CHARACTERS, i);
		}
		public List<TerminalNode> COLON() { return getTokens(PerlParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PerlParser.COLON, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(PerlParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(PerlParser.DIGIT, i);
		}
		public List<TerminalNode> DOT() { return getTokens(PerlParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PerlParser.DOT, i);
		}
		public TerminalNode STRING() { return getToken(PerlParser.STRING, 0); }
		public Require_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_require_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterRequire_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitRequire_statement(this);
		}
	}

	public final Require_statementContext require_statement() throws RecognitionException {
		Require_statementContext _localctx = new Require_statementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_require_statement);
		int _la;
		try {
			setState(186);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(T__3);
				{
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(140);
					match(CHARACTERS);
					}
					}
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CHARACTERS );
				}
				setState(145);
				match(SEMI_COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(T__3);
				{
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(147);
					match(CHARACTERS);
					}
					}
					setState(150); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CHARACTERS );
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COLON) {
					{
					{
					setState(152);
					match(COLON);
					setState(153);
					match(COLON);
					{
					setState(155); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(154);
						match(CHARACTERS);
						}
						}
						setState(157); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CHARACTERS );
					}
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(164);
				match(SEMI_COLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(T__3);
				{
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(166);
					match(DIGIT);
					}
					}
					setState(169); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(171);
					match(DOT);
					{
					setState(173); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(172);
						match(DIGIT);
						}
						}
						setState(175); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==DIGIT );
					}
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(182);
				match(SEMI_COLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(T__3);
				setState(184);
				match(STRING);
				setState(185);
				match(SEMI_COLON);
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

	public static class Variable_declarationContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE() { return getTokens(PerlParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(PerlParser.VARIABLE, i);
		}
		public TerminalNode SEMI_COLON() { return getToken(PerlParser.SEMI_COLON, 0); }
		public TerminalNode VARIABLE_SCOPE() { return getToken(PerlParser.VARIABLE_SCOPE, 0); }
		public Variable_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterVariable_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitVariable_declaration(this);
		}
	}

	public final Variable_declarationContext variable_declaration() throws RecognitionException {
		Variable_declarationContext _localctx = new Variable_declarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_variable_declaration);
		int _la;
		try {
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				_la = _input.LA(1);
				if (_la==VARIABLE_SCOPE) {
					{
					setState(188);
					match(VARIABLE_SCOPE);
					}
				}

				setState(191);
				match(VARIABLE);
				setState(192);
				match(SEMI_COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				_la = _input.LA(1);
				if (_la==VARIABLE_SCOPE) {
					{
					setState(193);
					match(VARIABLE_SCOPE);
					}
				}

				setState(196);
				match(LPAREN);
				setState(197);
				match(VARIABLE);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(198);
					match(COMMA);
					setState(199);
					match(VARIABLE);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
				match(RPAREN);
				setState(206);
				match(SEMI_COLON);
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

	public static class Comment_statementsContext extends ParserRuleContext {
		public List<Comment_statementContext> comment_statement() {
			return getRuleContexts(Comment_statementContext.class);
		}
		public Comment_statementContext comment_statement(int i) {
			return getRuleContext(Comment_statementContext.class,i);
		}
		public Comment_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterComment_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitComment_statements(this);
		}
	}

	public final Comment_statementsContext comment_statements() throws RecognitionException {
		Comment_statementsContext _localctx = new Comment_statementsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_comment_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(210); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(209);
					comment_statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(212); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class Comment_statementContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(PerlParser.COMMENT, 0); }
		public Comment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).enterComment_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PerlListener ) ((PerlListener)listener).exitComment_statement(this);
		}
	}

	public final Comment_statementContext comment_statement() throws RecognitionException {
		Comment_statementContext _localctx = new Comment_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(COMMENT);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u00db\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\6\2\32\n\2\r\2\16\2\33\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3"+
		"%\n\3\3\4\6\4(\n\4\r\4\16\4)\3\5\3\5\6\5.\n\5\r\5\16\5/\3\6\3\6\6\6\64"+
		"\n\6\r\6\16\6\65\3\6\3\6\3\6\6\6;\n\6\r\6\16\6<\7\6?\n\6\f\6\16\6B\13"+
		"\6\3\6\3\6\3\7\3\7\3\7\6\7I\n\7\r\7\16\7J\3\7\3\7\3\7\3\7\3\7\7\7R\n\7"+
		"\f\7\16\7U\13\7\3\7\3\7\6\7Y\n\7\r\7\16\7Z\3\7\3\7\3\7\3\7\3\7\7\7b\n"+
		"\7\f\7\16\7e\13\7\3\7\3\7\6\7i\n\7\r\7\16\7j\5\7m\n\7\3\b\3\b\6\bq\n\b"+
		"\r\b\16\br\3\b\3\b\3\b\6\bx\n\b\r\b\16\by\3\b\3\b\3\b\6\b\177\n\b\r\b"+
		"\16\b\u0080\7\b\u0083\n\b\f\b\16\b\u0086\13\b\3\b\3\b\3\b\3\b\5\b\u008c"+
		"\n\b\3\t\3\t\6\t\u0090\n\t\r\t\16\t\u0091\3\t\3\t\3\t\6\t\u0097\n\t\r"+
		"\t\16\t\u0098\3\t\3\t\3\t\6\t\u009e\n\t\r\t\16\t\u009f\7\t\u00a2\n\t\f"+
		"\t\16\t\u00a5\13\t\3\t\3\t\3\t\6\t\u00aa\n\t\r\t\16\t\u00ab\3\t\3\t\6"+
		"\t\u00b0\n\t\r\t\16\t\u00b1\7\t\u00b4\n\t\f\t\16\t\u00b7\13\t\3\t\3\t"+
		"\3\t\3\t\5\t\u00bd\n\t\3\n\5\n\u00c0\n\n\3\n\3\n\3\n\5\n\u00c5\n\n\3\n"+
		"\3\n\3\n\3\n\7\n\u00cb\n\n\f\n\16\n\u00ce\13\n\3\n\3\n\5\n\u00d2\n\n\3"+
		"\13\6\13\u00d5\n\13\r\13\16\13\u00d6\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16"+
		"\20\22\24\26\2\3\4\2\13\13++\u00f6\2\31\3\2\2\2\4$\3\2\2\2\6\'\3\2\2\2"+
		"\b-\3\2\2\2\n\61\3\2\2\2\fl\3\2\2\2\16\u008b\3\2\2\2\20\u00bc\3\2\2\2"+
		"\22\u00d1\3\2\2\2\24\u00d4\3\2\2\2\26\u00d8\3\2\2\2\30\32\5\4\3\2\31\30"+
		"\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\35\3\2\2\2\35\36"+
		"\7\2\2\3\36\3\3\2\2\2\37%\5\6\4\2 %\5\24\13\2!%\5\22\n\2\"%\5\f\7\2#%"+
		"\5\n\6\2$\37\3\2\2\2$ \3\2\2\2$!\3\2\2\2$\"\3\2\2\2$#\3\2\2\2%\5\3\2\2"+
		"\2&(\5\b\5\2\'&\3\2\2\2()\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\7\3\2\2\2+.\5"+
		"\16\b\2,.\5\20\t\2-+\3\2\2\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2"+
		"\60\t\3\2\2\2\61\63\7\3\2\2\62\64\7-\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65"+
		"\63\3\2\2\2\65\66\3\2\2\2\66@\3\2\2\2\678\7\24\2\28:\7\24\2\29;\7-\2\2"+
		":9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2>\67\3\2\2\2?B\3\2\2"+
		"\2@>\3\2\2\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7\23\2\2D\13\3\2\2\2EF\7"+
		"\4\2\2FH\t\2\2\2GI\7\23\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2Km"+
		"\3\2\2\2LM\7\4\2\2MN\7\16\2\2NS\7+\2\2OP\7\22\2\2PR\7+\2\2QO\3\2\2\2R"+
		"U\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VX\7\17\2\2WY\7\23\2"+
		"\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[m\3\2\2\2\\]\7\4\2\2]^\7\16"+
		"\2\2^c\7\13\2\2_`\7\22\2\2`b\7\13\2\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd"+
		"\3\2\2\2df\3\2\2\2ec\3\2\2\2fh\7\17\2\2gi\7\23\2\2hg\3\2\2\2ij\3\2\2\2"+
		"jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lE\3\2\2\2lL\3\2\2\2l\\\3\2\2\2m\r\3\2\2"+
		"\2np\7\5\2\2oq\7-\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2"+
		"\2t\u008c\7\23\2\2uw\7\5\2\2vx\7-\2\2wv\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz"+
		"\3\2\2\2z\u0084\3\2\2\2{|\7\24\2\2|~\7\24\2\2}\177\7-\2\2~}\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2"+
		"\u0082{\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3"+
		"\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u008c\7\23\2\2\u0088"+
		"\u0089\7\5\2\2\u0089\u008a\7/\2\2\u008a\u008c\7\23\2\2\u008bn\3\2\2\2"+
		"\u008bu\3\2\2\2\u008b\u0088\3\2\2\2\u008c\17\3\2\2\2\u008d\u008f\7\6\2"+
		"\2\u008e\u0090\7-\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u00bd\7\23\2\2"+
		"\u0094\u0096\7\6\2\2\u0095\u0097\7-\2\2\u0096\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u00a3\3\2\2\2\u009a"+
		"\u009b\7\24\2\2\u009b\u009d\7\24\2\2\u009c\u009e\7-\2\2\u009d\u009c\3"+
		"\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a2\3\2\2\2\u00a1\u009a\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2"+
		"\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00bd\7\23\2\2\u00a7\u00a9\7\6\2\2\u00a8\u00aa\7*\2\2\u00a9\u00a8\3\2"+
		"\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00b5\3\2\2\2\u00ad\u00af\7\25\2\2\u00ae\u00b0\7*\2\2\u00af\u00ae\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b4\3\2\2\2\u00b3\u00ad\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8"+
		"\u00bd\7\23\2\2\u00b9\u00ba\7\6\2\2\u00ba\u00bb\7/\2\2\u00bb\u00bd\7\23"+
		"\2\2\u00bc\u008d\3\2\2\2\u00bc\u0094\3\2\2\2\u00bc\u00a7\3\2\2\2\u00bc"+
		"\u00b9\3\2\2\2\u00bd\21\3\2\2\2\u00be\u00c0\7\t\2\2\u00bf\u00be\3\2\2"+
		"\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2\u00d2"+
		"\7\23\2\2\u00c3\u00c5\7\t\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2"+
		"\u00c5\u00c6\3\2\2\2\u00c6\u00c7\7\16\2\2\u00c7\u00cc\7+\2\2\u00c8\u00c9"+
		"\7\22\2\2\u00c9\u00cb\7+\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2"+
		"\2\2\u00cf\u00d0\7\17\2\2\u00d0\u00d2\7\23\2\2\u00d1\u00bf\3\2\2\2\u00d1"+
		"\u00c4\3\2\2\2\u00d2\23\3\2\2\2\u00d3\u00d5\5\26\f\2\u00d4\u00d3\3\2\2"+
		"\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\25"+
		"\3\2\2\2\u00d8\u00d9\7\b\2\2\u00d9\27\3\2\2\2\"\33$)-/\65<@JSZcjlry\u0080"+
		"\u0084\u008b\u0091\u0098\u009f\u00a3\u00ab\u00b1\u00b5\u00bc\u00bf\u00c4"+
		"\u00cc\u00d1\u00d6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}