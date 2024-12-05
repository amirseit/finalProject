// Generated from C:/Users/Admins/IdeaProjects/mainFYP/src/grammarAmir.g4 by ANTLR 4.13.1

    package parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link grammarAmirParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface grammarAmirVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(grammarAmirParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(grammarAmirParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(grammarAmirParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(grammarAmirParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#elifClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifClause(grammarAmirParser.ElifClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#elseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseClause(grammarAmirParser.ElseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(grammarAmirParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(grammarAmirParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#printStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStatement(grammarAmirParser.PrintStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(grammarAmirParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(grammarAmirParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(grammarAmirParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDeclaration(grammarAmirParser.ConstructorDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#classMethodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethodDeclaration(grammarAmirParser.ClassMethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(grammarAmirParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(grammarAmirParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(grammarAmirParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#statementBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementBlock(grammarAmirParser.StatementBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link grammarAmirParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(grammarAmirParser.AtomContext ctx);
}