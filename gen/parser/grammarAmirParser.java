// Generated from C:/Users/Admins/IdeaProjects/mainFYP/src/grammarAmir.g4 by ANTLR 4.13.1

    package parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class grammarAmirParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, ID=24, SELF_ID=25, 
		INT=26, STRING=27, OPERATOR=28, COMP_OP=29, NEWLINE=30, WS=31;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_definition = 2, RULE_assignment = 3, 
		RULE_elifClause = 4, RULE_elseClause = 5, RULE_ifStatement = 6, RULE_whileStatement = 7, 
		RULE_printStatement = 8, RULE_expression = 9, RULE_classDeclaration = 10, 
		RULE_classBody = 11, RULE_constructorDeclaration = 12, RULE_classMethodDeclaration = 13, 
		RULE_returnStatement = 14, RULE_parameters = 15, RULE_arguments = 16, 
		RULE_statementBlock = 17, RULE_atom = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "definition", "assignment", "elifClause", "elseClause", 
			"ifStatement", "whileStatement", "printStatement", "expression", "classDeclaration", 
			"classBody", "constructorDeclaration", "classMethodDeclaration", "returnStatement", 
			"parameters", "arguments", "statementBlock", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'.'", "'elif'", "':'", "'else'", "'if'", "'while'", "'print'", 
			"'not'", "'and'", "'or'", "'('", "')'", "'new'", "'class'", "'def'", 
			"'__init__'", "'self'", "','", "'return'", "'True'", "'False'", "'None'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ID", "SELF_ID", "INT", "STRING", "OPERATOR", "COMP_OP", "NEWLINE", "WS"
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
	public String getGrammarFileName() { return "grammarAmir.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public grammarAmirParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(grammarAmirParser.EOF, 0); }
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(grammarAmirParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(grammarAmirParser.NEWLINE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(38);
				definition();
				setState(39);
				match(NEWLINE);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266621888L) != 0)) {
				{
				{
				setState(46);
				statement();
				setState(47);
				match(NEWLINE);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__11:
			case T__13:
			case T__17:
			case T__20:
			case T__21:
			case T__22:
			case ID:
			case SELF_ID:
			case INT:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				assignment();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				ifStatement();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				whileStatement();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(59);
				printStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefinitionContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			classDeclaration();
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(grammarAmirParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SELF_ID() { return getToken(grammarAmirParser.SELF_ID, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				match(ID);
				setState(65);
				match(T__0);
				setState(66);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(SELF_ID);
				setState(68);
				match(T__0);
				setState(69);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				expression(0);
				setState(71);
				match(T__1);
				setState(72);
				match(ID);
				setState(73);
				match(T__0);
				setState(74);
				expression(0);
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
	public static class ElifClauseContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public ElifClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elifClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterElifClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitElifClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitElifClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElifClauseContext elifClause() throws RecognitionException {
		ElifClauseContext _localctx = new ElifClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_elifClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__2);
			setState(79);
			expression(0);
			setState(80);
			match(T__3);
			setState(81);
			statementBlock();
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
	public static class ElseClauseContext extends ParserRuleContext {
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public ElseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterElseClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitElseClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitElseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseClauseContext elseClause() throws RecognitionException {
		ElseClauseContext _localctx = new ElseClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_elseClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__4);
			setState(84);
			match(T__3);
			setState(85);
			statementBlock();
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
	public static class IfStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public List<ElifClauseContext> elifClause() {
			return getRuleContexts(ElifClauseContext.class);
		}
		public ElifClauseContext elifClause(int i) {
			return getRuleContext(ElifClauseContext.class,i);
		}
		public ElseClauseContext elseClause() {
			return getRuleContext(ElseClauseContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__5);
			setState(88);
			expression(0);
			setState(89);
			match(T__3);
			setState(90);
			statementBlock();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(91);
				elifClause();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(97);
				elseClause();
				}
			}

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
	public static class WhileStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__6);
			setState(101);
			expression(0);
			setState(102);
			match(T__3);
			setState(103);
			statementBlock();
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
	public static class PrintStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__7);
			setState(106);
			expression(0);
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
	public static class ExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(grammarAmirParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode OPERATOR() { return getToken(grammarAmirParser.OPERATOR, 0); }
		public TerminalNode COMP_OP() { return getToken(grammarAmirParser.COMP_OP, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				{
				setState(109);
				match(T__8);
				setState(110);
				expression(9);
				}
				break;
			case T__13:
				{
				setState(111);
				match(T__13);
				setState(112);
				match(ID);
				setState(113);
				match(T__11);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266621440L) != 0)) {
					{
					setState(114);
					arguments();
					}
				}

				setState(117);
				match(T__12);
				}
				break;
			case T__11:
			case T__17:
			case T__20:
			case T__21:
			case T__22:
			case ID:
			case SELF_ID:
			case INT:
			case STRING:
				{
				setState(118);
				atom();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(144);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(121);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(122);
						match(T__9);
						setState(123);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(124);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(125);
						match(T__10);
						setState(126);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(128);
						match(OPERATOR);
						setState(129);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(130);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(131);
						match(COMP_OP);
						setState(132);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(134);
						match(T__1);
						setState(135);
						match(ID);
						setState(136);
						match(T__11);
						setState(138);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266621440L) != 0)) {
							{
							setState(137);
							arguments();
							}
						}

						setState(140);
						match(T__12);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(142);
						match(T__1);
						setState(143);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(grammarAmirParser.ID, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__14);
			setState(150);
			match(ID);
			setState(151);
			classBody();
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
	public static class ClassBodyContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(grammarAmirParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(grammarAmirParser.NEWLINE, i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public List<ClassMethodDeclarationContext> classMethodDeclaration() {
			return getRuleContexts(ClassMethodDeclarationContext.class);
		}
		public ClassMethodDeclarationContext classMethodDeclaration(int i) {
			return getRuleContext(ClassMethodDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_classBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__3);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(154);
					match(NEWLINE);
					setState(155);
					assignment();
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(161);
				match(NEWLINE);
				setState(162);
				constructorDeclaration();
				}
				break;
			}
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(165);
					match(NEWLINE);
					setState(166);
					classMethodDeclaration();
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
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
	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(grammarAmirParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(grammarAmirParser.NEWLINE, i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitConstructorDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitConstructorDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constructorDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(T__15);
			setState(173);
			match(T__16);
			setState(174);
			match(T__11);
			setState(175);
			match(T__17);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(176);
				match(T__18);
				setState(177);
				parameters();
				}
			}

			setState(180);
			match(T__12);
			setState(181);
			match(T__3);
			setState(184); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(182);
					match(NEWLINE);
					setState(183);
					assignment();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(186); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMethodDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(grammarAmirParser.ID, 0); }
		public StatementBlockContext statementBlock() {
			return getRuleContext(StatementBlockContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ClassMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterClassMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitClassMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitClassMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMethodDeclarationContext classMethodDeclaration() throws RecognitionException {
		ClassMethodDeclarationContext _localctx = new ClassMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(T__15);
			setState(189);
			match(ID);
			setState(190);
			match(T__11);
			setState(191);
			match(T__17);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(192);
				match(T__18);
				setState(193);
				parameters();
				}
			}

			setState(196);
			match(T__12);
			setState(197);
			match(T__3);
			setState(198);
			statementBlock();
			setState(199);
			returnStatement();
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__19);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266621440L) != 0)) {
				{
				setState(202);
				expression(0);
				}
			}

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
	public static class ParametersContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(grammarAmirParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(grammarAmirParser.ID, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(ID);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(206);
				match(T__18);
				setState(207);
				match(ID);
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class ArgumentsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			expression(0);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(214);
				match(T__18);
				setState(215);
				expression(0);
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class StatementBlockContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(grammarAmirParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(grammarAmirParser.NEWLINE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterStatementBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitStatementBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitStatementBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementBlockContext statementBlock() throws RecognitionException {
		StatementBlockContext _localctx = new StatementBlockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statementBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(NEWLINE);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 266621888L) != 0)) {
				{
				{
				setState(222);
				statement();
				setState(223);
				match(NEWLINE);
				}
				}
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode SELF_ID() { return getToken(grammarAmirParser.SELF_ID, 0); }
		public TerminalNode ID() { return getToken(grammarAmirParser.ID, 0); }
		public TerminalNode INT() { return getToken(grammarAmirParser.INT, 0); }
		public TerminalNode STRING() { return getToken(grammarAmirParser.STRING, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammarAmirListener ) ((grammarAmirListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof grammarAmirVisitor ) return ((grammarAmirVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_atom);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				match(T__22);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				match(T__17);
				}
				break;
			case SELF_ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				match(SELF_ID);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 6);
				{
				setState(235);
				match(ID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 7);
				{
				setState(236);
				match(INT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 8);
				{
				setState(237);
				match(STRING);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 9);
				{
				setState(238);
				match(T__11);
				setState(239);
				expression(0);
				setState(240);
				match(T__12);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001f\u00f5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000*\b\u0000\n\u0000"+
		"\f\u0000-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u00002\b\u0000"+
		"\n\u0000\f\u00005\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001=\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003M\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006]\b\u0006"+
		"\n\u0006\f\u0006`\t\u0006\u0001\u0006\u0003\u0006c\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tt\b"+
		"\t\u0001\t\u0001\t\u0003\tx\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u008b\b\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u0091\b\t\n\t\f\t\u0094\t\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u009d\b\u000b\n\u000b"+
		"\f\u000b\u00a0\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a4\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0005\u000b\u00a8\b\u000b\n\u000b\f\u000b\u00ab"+
		"\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b3"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0001\f\u0004\f\u00b9\b\f\u000b\f\f\f\u00ba"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00c3\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u00cc\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00d1\b"+
		"\u000f\n\u000f\f\u000f\u00d4\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u00d9\b\u0010\n\u0010\f\u0010\u00dc\t\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u00e2\b\u0011\n\u0011\f\u0011"+
		"\u00e5\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00f3\b\u0012\u0001\u0012\u0000\u0001\u0012\u0013"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$\u0000\u0000\u0106\u0000+\u0001\u0000\u0000\u0000\u0002"+
		"<\u0001\u0000\u0000\u0000\u0004>\u0001\u0000\u0000\u0000\u0006L\u0001"+
		"\u0000\u0000\u0000\bN\u0001\u0000\u0000\u0000\nS\u0001\u0000\u0000\u0000"+
		"\fW\u0001\u0000\u0000\u0000\u000ed\u0001\u0000\u0000\u0000\u0010i\u0001"+
		"\u0000\u0000\u0000\u0012w\u0001\u0000\u0000\u0000\u0014\u0095\u0001\u0000"+
		"\u0000\u0000\u0016\u0099\u0001\u0000\u0000\u0000\u0018\u00ac\u0001\u0000"+
		"\u0000\u0000\u001a\u00bc\u0001\u0000\u0000\u0000\u001c\u00c9\u0001\u0000"+
		"\u0000\u0000\u001e\u00cd\u0001\u0000\u0000\u0000 \u00d5\u0001\u0000\u0000"+
		"\u0000\"\u00dd\u0001\u0000\u0000\u0000$\u00f2\u0001\u0000\u0000\u0000"+
		"&\'\u0003\u0004\u0002\u0000\'(\u0005\u001e\u0000\u0000(*\u0001\u0000\u0000"+
		"\u0000)&\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000"+
		"\u0000\u0000+,\u0001\u0000\u0000\u0000,3\u0001\u0000\u0000\u0000-+\u0001"+
		"\u0000\u0000\u0000./\u0003\u0002\u0001\u0000/0\u0005\u001e\u0000\u0000"+
		"02\u0001\u0000\u0000\u00001.\u0001\u0000\u0000\u000025\u0001\u0000\u0000"+
		"\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000"+
		"\u0000\u000053\u0001\u0000\u0000\u000067\u0005\u0000\u0000\u00017\u0001"+
		"\u0001\u0000\u0000\u00008=\u0003\u0006\u0003\u00009=\u0003\f\u0006\u0000"+
		":=\u0003\u000e\u0007\u0000;=\u0003\u0010\b\u0000<8\u0001\u0000\u0000\u0000"+
		"<9\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<;\u0001\u0000\u0000"+
		"\u0000=\u0003\u0001\u0000\u0000\u0000>?\u0003\u0014\n\u0000?\u0005\u0001"+
		"\u0000\u0000\u0000@A\u0005\u0018\u0000\u0000AB\u0005\u0001\u0000\u0000"+
		"BM\u0003\u0012\t\u0000CD\u0005\u0019\u0000\u0000DE\u0005\u0001\u0000\u0000"+
		"EM\u0003\u0012\t\u0000FG\u0003\u0012\t\u0000GH\u0005\u0002\u0000\u0000"+
		"HI\u0005\u0018\u0000\u0000IJ\u0005\u0001\u0000\u0000JK\u0003\u0012\t\u0000"+
		"KM\u0001\u0000\u0000\u0000L@\u0001\u0000\u0000\u0000LC\u0001\u0000\u0000"+
		"\u0000LF\u0001\u0000\u0000\u0000M\u0007\u0001\u0000\u0000\u0000NO\u0005"+
		"\u0003\u0000\u0000OP\u0003\u0012\t\u0000PQ\u0005\u0004\u0000\u0000QR\u0003"+
		"\"\u0011\u0000R\t\u0001\u0000\u0000\u0000ST\u0005\u0005\u0000\u0000TU"+
		"\u0005\u0004\u0000\u0000UV\u0003\"\u0011\u0000V\u000b\u0001\u0000\u0000"+
		"\u0000WX\u0005\u0006\u0000\u0000XY\u0003\u0012\t\u0000YZ\u0005\u0004\u0000"+
		"\u0000Z^\u0003\"\u0011\u0000[]\u0003\b\u0004\u0000\\[\u0001\u0000\u0000"+
		"\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ac\u0003"+
		"\n\u0005\u0000ba\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000c\r"+
		"\u0001\u0000\u0000\u0000de\u0005\u0007\u0000\u0000ef\u0003\u0012\t\u0000"+
		"fg\u0005\u0004\u0000\u0000gh\u0003\"\u0011\u0000h\u000f\u0001\u0000\u0000"+
		"\u0000ij\u0005\b\u0000\u0000jk\u0003\u0012\t\u0000k\u0011\u0001\u0000"+
		"\u0000\u0000lm\u0006\t\uffff\uffff\u0000mn\u0005\t\u0000\u0000nx\u0003"+
		"\u0012\t\top\u0005\u000e\u0000\u0000pq\u0005\u0018\u0000\u0000qs\u0005"+
		"\f\u0000\u0000rt\u0003 \u0010\u0000sr\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000ux\u0005\r\u0000\u0000vx\u0003"+
		"$\u0012\u0000wl\u0001\u0000\u0000\u0000wo\u0001\u0000\u0000\u0000wv\u0001"+
		"\u0000\u0000\u0000x\u0092\u0001\u0000\u0000\u0000yz\n\b\u0000\u0000z{"+
		"\u0005\n\u0000\u0000{\u0091\u0003\u0012\t\t|}\n\u0007\u0000\u0000}~\u0005"+
		"\u000b\u0000\u0000~\u0091\u0003\u0012\t\b\u007f\u0080\n\u0006\u0000\u0000"+
		"\u0080\u0081\u0005\u001c\u0000\u0000\u0081\u0091\u0003\u0012\t\u0007\u0082"+
		"\u0083\n\u0005\u0000\u0000\u0083\u0084\u0005\u001d\u0000\u0000\u0084\u0091"+
		"\u0003\u0012\t\u0006\u0085\u0086\n\u0004\u0000\u0000\u0086\u0087\u0005"+
		"\u0002\u0000\u0000\u0087\u0088\u0005\u0018\u0000\u0000\u0088\u008a\u0005"+
		"\f\u0000\u0000\u0089\u008b\u0003 \u0010\u0000\u008a\u0089\u0001\u0000"+
		"\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000"+
		"\u0000\u0000\u008c\u0091\u0005\r\u0000\u0000\u008d\u008e\n\u0003\u0000"+
		"\u0000\u008e\u008f\u0005\u0002\u0000\u0000\u008f\u0091\u0005\u0018\u0000"+
		"\u0000\u0090y\u0001\u0000\u0000\u0000\u0090|\u0001\u0000\u0000\u0000\u0090"+
		"\u007f\u0001\u0000\u0000\u0000\u0090\u0082\u0001\u0000\u0000\u0000\u0090"+
		"\u0085\u0001\u0000\u0000\u0000\u0090\u008d\u0001\u0000\u0000\u0000\u0091"+
		"\u0094\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093\u0013\u0001\u0000\u0000\u0000\u0094"+
		"\u0092\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u000f\u0000\u0000\u0096"+
		"\u0097\u0005\u0018\u0000\u0000\u0097\u0098\u0003\u0016\u000b\u0000\u0098"+
		"\u0015\u0001\u0000\u0000\u0000\u0099\u009e\u0005\u0004\u0000\u0000\u009a"+
		"\u009b\u0005\u001e\u0000\u0000\u009b\u009d\u0003\u0006\u0003\u0000\u009c"+
		"\u009a\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e"+
		"\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0005\u001e\u0000\u0000\u00a2\u00a4\u0003\u0018\f\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u001e\u0000\u0000\u00a6\u00a8"+
		"\u0003\u001a\r\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001"+
		"\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001"+
		"\u0000\u0000\u0000\u00aa\u0017\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0005\u0010\u0000\u0000\u00ad\u00ae\u0005"+
		"\u0011\u0000\u0000\u00ae\u00af\u0005\f\u0000\u0000\u00af\u00b2\u0005\u0012"+
		"\u0000\u0000\u00b0\u00b1\u0005\u0013\u0000\u0000\u00b1\u00b3\u0003\u001e"+
		"\u000f\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\r\u0000"+
		"\u0000\u00b5\u00b8\u0005\u0004\u0000\u0000\u00b6\u00b7\u0005\u001e\u0000"+
		"\u0000\u00b7\u00b9\u0003\u0006\u0003\u0000\u00b8\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u0019\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0010\u0000\u0000\u00bd\u00be\u0005\u0018\u0000"+
		"\u0000\u00be\u00bf\u0005\f\u0000\u0000\u00bf\u00c2\u0005\u0012\u0000\u0000"+
		"\u00c0\u00c1\u0005\u0013\u0000\u0000\u00c1\u00c3\u0003\u001e\u000f\u0000"+
		"\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\r\u0000\u0000\u00c5"+
		"\u00c6\u0005\u0004\u0000\u0000\u00c6\u00c7\u0003\"\u0011\u0000\u00c7\u00c8"+
		"\u0003\u001c\u000e\u0000\u00c8\u001b\u0001\u0000\u0000\u0000\u00c9\u00cb"+
		"\u0005\u0014\u0000\u0000\u00ca\u00cc\u0003\u0012\t\u0000\u00cb\u00ca\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u001d\u0001"+
		"\u0000\u0000\u0000\u00cd\u00d2\u0005\u0018\u0000\u0000\u00ce\u00cf\u0005"+
		"\u0013\u0000\u0000\u00cf\u00d1\u0005\u0018\u0000\u0000\u00d0\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u001f\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5\u00da\u0003"+
		"\u0012\t\u0000\u00d6\u00d7\u0005\u0013\u0000\u0000\u00d7\u00d9\u0003\u0012"+
		"\t\u0000\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d9\u00dc\u0001\u0000\u0000"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db!\u0001\u0000\u0000\u0000\u00dc\u00da\u0001\u0000\u0000\u0000"+
		"\u00dd\u00e3\u0005\u001e\u0000\u0000\u00de\u00df\u0003\u0002\u0001\u0000"+
		"\u00df\u00e0\u0005\u001e\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e1\u00de\u0001\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e4#\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e6"+
		"\u00f3\u0005\u0015\u0000\u0000\u00e7\u00f3\u0005\u0016\u0000\u0000\u00e8"+
		"\u00f3\u0005\u0017\u0000\u0000\u00e9\u00f3\u0005\u0012\u0000\u0000\u00ea"+
		"\u00f3\u0005\u0019\u0000\u0000\u00eb\u00f3\u0005\u0018\u0000\u0000\u00ec"+
		"\u00f3\u0005\u001a\u0000\u0000\u00ed\u00f3\u0005\u001b\u0000\u0000\u00ee"+
		"\u00ef\u0005\f\u0000\u0000\u00ef\u00f0\u0003\u0012\t\u0000\u00f0\u00f1"+
		"\u0005\r\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000\u00f2\u00e6\u0001"+
		"\u0000\u0000\u0000\u00f2\u00e7\u0001\u0000\u0000\u0000\u00f2\u00e8\u0001"+
		"\u0000\u0000\u0000\u00f2\u00e9\u0001\u0000\u0000\u0000\u00f2\u00ea\u0001"+
		"\u0000\u0000\u0000\u00f2\u00eb\u0001\u0000\u0000\u0000\u00f2\u00ec\u0001"+
		"\u0000\u0000\u0000\u00f2\u00ed\u0001\u0000\u0000\u0000\u00f2\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f3%\u0001\u0000\u0000\u0000\u0016+3<L^bsw\u008a"+
		"\u0090\u0092\u009e\u00a3\u00a9\u00b2\u00ba\u00c2\u00cb\u00d2\u00da\u00e3"+
		"\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}