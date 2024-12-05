// Generated from C:/Users/Admins/IdeaProjects/mainFYP/src/grammarAmir.g4 by ANTLR 4.13.1

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammarAmirParser}.
 */
public interface grammarAmirListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(grammarAmirParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(grammarAmirParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(grammarAmirParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(grammarAmirParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(grammarAmirParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(grammarAmirParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(grammarAmirParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(grammarAmirParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#elifClause}.
	 * @param ctx the parse tree
	 */
	void enterElifClause(grammarAmirParser.ElifClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#elifClause}.
	 * @param ctx the parse tree
	 */
	void exitElifClause(grammarAmirParser.ElifClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void enterElseClause(grammarAmirParser.ElseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#elseClause}.
	 * @param ctx the parse tree
	 */
	void exitElseClause(grammarAmirParser.ElseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(grammarAmirParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(grammarAmirParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(grammarAmirParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(grammarAmirParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(grammarAmirParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#printStatement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(grammarAmirParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(grammarAmirParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(grammarAmirParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(grammarAmirParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(grammarAmirParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(grammarAmirParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(grammarAmirParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(grammarAmirParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(grammarAmirParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#classMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMethodDeclaration(grammarAmirParser.ClassMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#classMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMethodDeclaration(grammarAmirParser.ClassMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(grammarAmirParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(grammarAmirParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(grammarAmirParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(grammarAmirParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(grammarAmirParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(grammarAmirParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void enterStatementBlock(grammarAmirParser.StatementBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#statementBlock}.
	 * @param ctx the parse tree
	 */
	void exitStatementBlock(grammarAmirParser.StatementBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammarAmirParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(grammarAmirParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammarAmirParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(grammarAmirParser.AtomContext ctx);
}