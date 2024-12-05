package converter;

import ast.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import parser.grammarAmirParser;

import java.util.*;

public class CSTtoASTConverter {

    public AmirProgram convertToAST(grammarAmirParser.ProgramContext programContext) {
        List<AmirDefinition> definitions = new ArrayList<>();
        List<AmirStatement> statements = new ArrayList<>();

        System.out.println("Converting CST to AST");
        for (ParseTree child : programContext.children) {
            if (child instanceof TerminalNodeImpl) { // Skip terminal nodes like NEWLINE and EOF
                continue;
            }

            System.out.println("Child class: " + child.getClass().getSimpleName());
            // Attempt to dynamically determine the type of child and convert it
            if (child instanceof grammarAmirParser.DefinitionContext) { // Skip terminal nodes like NEWLINE and EOF
                AmirDefinition definition = convertDefinition(child);
                if (definitions != null) {
                    definitions.add(definition);
                } else {
                    throw new RuntimeException("Failed to convert child: " + child.getText());
                }
            }
            if (child instanceof grammarAmirParser.StatementContext) { // Skip terminal nodes like NEWLINE and EOF
                AmirStatement statement = convertStatement(child);
                if (statement != null) {
                    statements.add(statement);
                } else {
                    throw new RuntimeException("Failed to convert child: " + child.getText());
                }
            }
        }

        System.out.println("Total statements converted: " + statements.size());

        return new AmirProgram(definitions, statements);
    }
    public AmirDefinition convertDefinition(ParseTree tree) {
        // Check if the tree is an instance of DefinitionContext
        if (tree instanceof grammarAmirParser.DefinitionContext) {
            grammarAmirParser.DefinitionContext definitionContext = (grammarAmirParser.DefinitionContext) tree;
            if (definitionContext.classDeclaration() != null) {
                System.out.println("Handling class definition");
                return handleClassDeclaration(definitionContext.classDeclaration());
            }
        }
        throw new RuntimeException("Unrecognized definition type: " + tree.getClass().getSimpleName());
    }
    public AmirStatement convertStatement(ParseTree tree) {
        // Check if the tree is an instance of StatementContext
        if (tree instanceof grammarAmirParser.StatementContext) {
            grammarAmirParser.StatementContext stmtContext = (grammarAmirParser.StatementContext) tree;
            // Check for and handle each type of statement
            if (stmtContext.assignment() != null && stmtContext.assignment().expression().size() == 1) {
                System.out.println("Handling assignment");
                return handleDeclareAssignment(stmtContext.assignment());
            } else if (stmtContext.assignment() != null && stmtContext.assignment().expression().size() == 2) {
                System.out.println("Handling object attribute assignment");
                return handleObjectPropertyAssign(stmtContext.assignment());
            } else if (stmtContext.ifStatement() != null) {
                System.out.println("Handling if statement");
                return handleIfStatement(stmtContext.ifStatement());
            } else if (stmtContext.whileStatement() != null) {
                System.out.println("Handling while loop");
                return handleWhileLoop(stmtContext.whileStatement());
            } else if (stmtContext.printStatement() != null) {
                System.out.println("Handling print statement");
                return handlePrintStatement(stmtContext.printStatement());
            }
        }
        throw new RuntimeException("Unrecognized statement type: " + tree.getClass().getSimpleName());
    }

    private boolean checkIDLegal(String identifier) {
        // List of reserved keywords
        Set<String> reservedWords = new HashSet<>(Arrays.asList(
                "new", "and", "or", "not", "True", "False", "if", "else", "elif",
                "while", "print", "class", "def", "return", "self"
        ));
        // I think self only cannot be used in assignment, otherwise it's good
        // Check if the identifier is a reserved word
        return !reservedWords.contains(identifier);
    }

    public AmirExpression convertExpression(grammarAmirParser.ExpressionContext ctx) {
        if (ctx.atom() != null) {
            return handleAtom(ctx.atom());
        }
        if (ctx.getText().startsWith("not") && ctx.expression().size() == 1) {
            return handleNotExpression(ctx);
        }
        if (ctx.OPERATOR() != null && ctx.expression().size() > 1) {
            return handleBinaryExpression(ctx);
        }
        if (ctx.COMP_OP() != null && ctx.expression().size() > 1) {
            // This condition checks for comparison expressions
            return handleCompExpression(ctx);
        }
        if ((ctx.getText().contains("and") || ctx.getText().contains("or")) && ctx.expression().size() > 1) {
            return handleLogicalExpression(ctx);
        }
        if (ctx.getText().startsWith("new")) {  // Detecting 'new ID(args?)' expression
            return handleObjectInstance(ctx);
        }
        if (ctx.getChildCount() > 1 && ctx.ID() != null) {
            if (ctx.arguments() != null || ctx.getText().contains("()")) {
                // This checks for method call (with or without arguments)
                return handleObjectMethodCall(ctx);
            } else {
                // This handles field access when there are no parentheses
                return handleObjectAttributeAccess(ctx);
            }
        }
        throw new RuntimeException("Unhandled expression type: " + ctx.getText());
    }

    private List<AmirExpression> convertArguments(grammarAmirParser.ArgumentsContext ctx) {
        List<AmirExpression> args = new ArrayList<>();
        for (grammarAmirParser.ExpressionContext exprCtx : ctx.expression()) {
            args.add(convertExpression(exprCtx));
        }
        return args;
    }

    private AmirDeclareAssign handleDeclareAssignment(grammarAmirParser.AssignmentContext context) {
        String id = null;
        if (context.SELF_ID() != null) {
            id = context.SELF_ID().getText().substring(5); // remove 'self.' prefix
            AmirExpression expression = convertExpression(context.expression(0));
            return new AmirDeclareAssign(id, expression, true);
        }
        else if (context.ID() != null) {
            // Handle identifiers
            id = context.ID().getText();
            AmirExpression expression = convertExpression(context.expression(0));
            return new AmirDeclareAssign(id, expression, false);
        }
        throw new RuntimeException("Unhandled atom type: " + context.getText());
    }

    private AmirObjectPropertyAssign handleObjectPropertyAssign(grammarAmirParser.AssignmentContext context) {
        String id = null;
        if (context.expression().size() == 2) {
            // Handling 'expression.ID = expression'
            AmirExpression targetObject = convertExpression(context.expression(0));
            id = context.ID().getText();
            AmirExpression expression = convertExpression(context.expression(1));

            // You need a different constructor or method to handle object property assignments
            return new AmirObjectPropertyAssign(targetObject, id, expression);
        }
        throw new RuntimeException("Unhandled atom type: " + context.getText());
    }

    public AmirExpression handleBinaryExpression(grammarAmirParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            // Single child, no operators involved, directly convert it
            return convertExpression(ctx.expression(0));
        }
        AmirExpression result = convertExpression(ctx.expression(0));

        int expressionIndex = 1; // Start with the second expression
        for (int i = 1; i < ctx.getChildCount(); i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) element;
                if (node.getSymbol().getType() == grammarAmirParser.OPERATOR) {
                    String operator = node.getText();
                    AmirExpression right = convertExpression(ctx.expression(expressionIndex++));
                    result = new AmirBinaryExpression(result, right, operator);
                }
            }
        }
        return result;
    }

    public AmirExpression handleCompExpression(grammarAmirParser.ExpressionContext ctx) {
        // Assuming you want to handle comparison expressions similar to binary expressions
        if (ctx.getChildCount() == 1) {
            // Single child, no operators involved, directly convert it
            return convertExpression(ctx.expression(0));
        }
        // Start with the first expression and apply each comparison operation in sequence
        AmirExpression result = convertExpression(ctx.expression(0));
        int expressionIndex = 1; // Start with the second expression
        for (int i = 1; i < ctx.getChildCount(); i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) element;
                if (node.getSymbol().getType() == grammarAmirParser.COMP_OP) {
                    String operator = node.getText();
                    AmirExpression right = convertExpression(ctx.expression(expressionIndex++));
                    result = new AmirCompExpression(result, right, operator);
                }
            }
        }
        return result;
    }
    public AmirExpression handleLogicalExpression(grammarAmirParser.ExpressionContext ctx) {
        if (ctx.getChildCount() == 1) {
            // Single child, no operators involved, directly convert it
            return convertExpression(ctx.expression(0));
        }
        // Start with the first expression and apply each logical operation in sequence
        AmirExpression result = convertExpression(ctx.expression(0));
        int expressionIndex = 1; // Start with the second expression
        for (int i = 1; i < ctx.getChildCount(); i++) {
            ParseTree element = ctx.getChild(i);
            if (element instanceof TerminalNode) {
                TerminalNode node = (TerminalNode) element;
                if (node.getText().equals("and") || node.getText().equals("or")) {
                    String operator = node.getText();
                    AmirExpression right = convertExpression(ctx.expression(expressionIndex++));
                    result = new AmirLogicalExpression(result, right, operator);
                }
            }
        }
        return result;
    }

    public AmirExpression handleNotExpression(grammarAmirParser.ExpressionContext ctx) {
        // Since 'not' is a unary operator, there should only be one expression following it.
        AmirExpression operand = convertExpression(ctx.expression(0));
        return new AmirNotExpression(operand);
    }
    private AmirExpression handleAtom(grammarAmirParser.AtomContext context) {
        if (context.SELF_ID() != null) {
            String variable = context.SELF_ID().getText().substring(5); // remove 'self.' prefix
            return new AmirSelfVariable(variable);
        } else if ("self".equals(context.getText())) {
            return new AmirSelfReference(); // Handles standalone self
        } else if (context.ID() != null) {
            // Handle identifiers
            return new AmirVariableReference(context.ID().getText());
        } else if (context.INT() != null) {
            // Handle integer literals
            return new AmirLiteral(Integer.parseInt(context.INT().getText()));
        } else if (context.STRING() != null) {
            // Handle string literals
            String text = context.STRING().getText();
            // Remove the surrounding quotes from the string literal
            return new AmirLiteral(text.substring(1, text.length() - 1));
        } else if (context.expression() != null) {
            // Handle expressions within parentheses
            return convertExpression(context.expression());
        } else {
            switch (context.getText()) {
                case "True":
                    return new AmirLiteral(true);
                case "False":
                    return new AmirLiteral(false);
                case "None":
                    return new AmirLiteral(null);
                default:
                    throw new RuntimeException("Unhandled atom type: " + context.getText());
            }
        }
    }

    private AmirStatement handlePrintStatement(grammarAmirParser.PrintStatementContext context) {
        // Extract and convert the expression to be printed
        AmirExpression expression = convertExpression(context.expression());
        // Create and return the AmirPrintStatement object
        return new AmirPrintStatement(expression);
    }

    private List<AmirStatement> handleStatementBlock(grammarAmirParser.StatementBlockContext context) {
        List<AmirStatement> statements = new ArrayList<>();
        for (grammarAmirParser.StatementContext statementContext : context.statement()) {
            statements.add(convertStatement(statementContext));
        }
        return statements;
    }

    private AmirStatement handleWhileLoop(grammarAmirParser.WhileStatementContext context) {
        // Extract the condition of the while loop
        AmirExpression condition = convertExpression(context.expression());

        // Extract the statements that form the body of the while loop using the handleStatementBlock method
        List<AmirStatement> bodyStatements = new ArrayList<>();
        if (context.statementBlock() != null) {
            bodyStatements = handleStatementBlock(context.statementBlock());
        }

        // Create and return the AmirWhileLoop object
        return new AmirWhileLoop(condition, bodyStatements);
    }

    private AmirStatement handleIfStatement(grammarAmirParser.IfStatementContext context) {
        AmirExpression ifCondition = convertExpression(context.expression());
        List<AmirStatement> thenBlock = new ArrayList<>();
        if (context.statementBlock() != null) {
            thenBlock = handleStatementBlock(context.statementBlock());
        }

        List<AmirIfStatement.ElifClause> elifClauses = new ArrayList<>();
        for (grammarAmirParser.ElifClauseContext elifClauseContext : context.elifClause()) {
            elifClauses.add(handleElifClause(elifClauseContext));
        }

        AmirIfStatement.ElseClause elseBlock = null;
        if (context.elseClause() != null) {
            elseBlock = handleElseClause(context.elseClause());
        }
        //System.out.println(elifClauses.get(0).getCondition());
        return new AmirIfStatement(ifCondition, thenBlock, elifClauses, elseBlock);
    }


    private AmirIfStatement.ElifClause handleElifClause(grammarAmirParser.ElifClauseContext context) {
        AmirExpression condition = convertExpression(context.expression());
        List<AmirStatement> elifStatementBlock = new ArrayList<>();
        if (context.statementBlock() != null) {
            elifStatementBlock = handleStatementBlock(context.statementBlock());
        }
        return new AmirIfStatement.ElifClause(condition, elifStatementBlock);
    }

    private AmirIfStatement.ElseClause handleElseClause(grammarAmirParser.ElseClauseContext context) {
        List<AmirStatement> elseStatementBlock = new ArrayList<>();
        if (context.statementBlock() != null) {
            elseStatementBlock = handleStatementBlock(context.statementBlock());
        }
        return new AmirIfStatement.ElseClause(elseStatementBlock);
    }

    private AmirClassDefinition handleClassDeclaration(grammarAmirParser.ClassDeclarationContext context) {
        String className = context.ID().getText();  // Get the class name
        List<AmirDeclareAssign> fields = new ArrayList<>();
        List<AmirConstructorDefinition> constructors = new ArrayList<>();
        List<AmirMethodDefinition> methods = new ArrayList<>();

        grammarAmirParser.ClassBodyContext classBodyContext = context.classBody();

        // Process fields
        for (grammarAmirParser.AssignmentContext fieldContext : classBodyContext.assignment()) {
            fields.add(handleDeclareAssignment(fieldContext));
        }

        // Process constructor, if present
        if (classBodyContext.constructorDeclaration() != null) {
            constructors.add(handleConstructorDeclaration(classBodyContext.constructorDeclaration()));
        }

        // Process methods
        for (grammarAmirParser.ClassMethodDeclarationContext methodContext : classBodyContext.classMethodDeclaration()) {
            methods.add(handleClassMethodDeclaration(methodContext));
        }

        return new AmirClassDefinition(className, fields, constructors, methods);
    }

    private AmirConstructorDefinition handleConstructorDeclaration(grammarAmirParser.ConstructorDeclarationContext context) {
        List<AmirParameter> parameters = new ArrayList<>();
        parameters.add(new AmirParameter("self"));
        // Processing parameters if any
        if (context.parameters() != null) {
            for (TerminalNode param : context.parameters().ID()) {
                AmirParameter parameter = new AmirParameter(param.getText());
                parameters.add(parameter);
            }
        }
        List<AmirDeclareAssign> bodyAssignments = new ArrayList<>();
        // Extract Assignments from all the assignment contexts
        for (grammarAmirParser.AssignmentContext assignmentContext : context.assignment()) {
            bodyAssignments.add(handleDeclareAssignment(assignmentContext));
        }
        return new AmirConstructorDefinition(parameters, bodyAssignments);
    }

    public AmirMethodDefinition handleClassMethodDeclaration(grammarAmirParser.ClassMethodDeclarationContext context) {
        String methodName = context.ID().getText();
        List<AmirParameter> parameters = new ArrayList<>();
        parameters.add(new AmirParameter("self"));
        // Processing parameters if any
        if (context.parameters() != null) {
            for (TerminalNode param : context.parameters().ID()) {
                AmirParameter parameter = new AmirParameter(param.getText());
                parameters.add(parameter);
            }
        }

        List<AmirStatement> bodyStatements = new ArrayList<>();
        if (context.statementBlock() != null) {
            bodyStatements = handleStatementBlock(context.statementBlock());
        }

        AmirReturnStatement returnStatement = null;
        if (context.returnStatement() != null) {
            if (context.returnStatement().expression() != null) {
                AmirExpression returnExpression = convertExpression(context.returnStatement().expression());
                returnStatement = new AmirReturnStatement(returnExpression);
            } else {
                // If there's no expression, it's equivalent to "return None"
                returnStatement = new AmirReturnStatement(null);
            }
        }
        return new AmirMethodDefinition(methodName, parameters, bodyStatements, returnStatement);
    }

    public AmirExpression handleObjectInstance(grammarAmirParser.ExpressionContext ctx) {
        String className = ctx.ID().getText(); // Get the class name from the expression
        List<AmirExpression> args = new ArrayList<>();
        if (ctx.arguments() != null) {
            args = convertArguments(ctx.arguments());
        }
        return new AmirObjectInstance(className, args);
    }

    private AmirExpression handleObjectAttributeAccess(grammarAmirParser.ExpressionContext ctx) {
        AmirExpression object = convertExpression(ctx.expression(0));  // Convert the base object expression
        String attribute = ctx.ID().getText();  // The attribute name after the '.'
        return new AmirFieldAccess(object, attribute);
    }

    private AmirExpression handleObjectMethodCall(grammarAmirParser.ExpressionContext ctx) {
        AmirExpression object = convertExpression(ctx.expression(0));
        String methodName = ctx.ID().getText();
        List<AmirExpression> methodArgs = new ArrayList<>();
        if (ctx.arguments() != null) {
            methodArgs = convertArguments(ctx.arguments());
        }
        return new AmirMethodCall(object, methodName, methodArgs);
    }

}
