package unitTests;

import static org.junit.jupiter.api.Assertions.*;

import ast.*;
import converter.CSTtoASTConverter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.grammarAmirLexer;
import parser.grammarAmirParser;

public class CSTtoASTConverterTest {
    private CSTtoASTConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new CSTtoASTConverter();
    }

    private grammarAmirParser createParser(String input) {
        grammarAmirLexer lexer = new grammarAmirLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new grammarAmirParser(tokens);
    }

    @Test
    public void testConvertEmptyProgram() {
        String input = "";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.program();
        AmirProgram ast = converter.convertToAST((grammarAmirParser.ProgramContext) tree);
        assertNotNull(ast, "AST should not be null");
        assertTrue(ast.getDefinitions().isEmpty(), "No definitions expected");
        assertTrue(ast.getStatements().isEmpty(), "No statements expected");
    }

    @Test
    public void testConvertWhileStatement() {
        String input = "while (true):\n    print 123\n";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.statement();
        AmirStatement statement = converter.convertStatement(tree);
        assertNotNull(statement, "Statement should not be null");
        assertTrue(statement instanceof AmirWhileLoop, "Expected a while loop statement");
    }

    @Test
    public void testConvertIfStatement() {
        String input = "if (x > 0):\n    print x\n";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.statement();
        AmirStatement statement = converter.convertStatement(tree);
        assertNotNull(statement, "Statement should not be null");
        assertTrue(statement instanceof AmirIfStatement, "Expected an if statement");
    }

    @Test
    public void testConvertPrintStatement() {
        String input = "print 123";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.statement();
        AmirStatement statement = converter.convertStatement(tree);
        assertNotNull(statement, "Statement should not be null");
        assertTrue(statement instanceof AmirPrintStatement, "Expected a print statement");
    }

    @Test
    public void testExpressionConversion() {
        String input = "(x > 5) and (y < 10) or not z";
        grammarAmirParser parser = createParser(input);
        grammarAmirParser.ExpressionContext tree = parser.expression();
        AmirExpression expression = converter.convertExpression(tree);
        assertNotNull(expression, "Expression should not be null");
    }

    @Test
    public void testConvertClassDefinition() {
        String input = "class MyClass:\n    x = 10\n    def myMethod(self):\n        print self.x\nreturn\n";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.definition();
        AmirDefinition definition = converter.convertDefinition(tree);
        assertNotNull(definition, "Definition should not be null");
        assertTrue(definition instanceof AmirClassDefinition, "Expected a class definition");
    }

    @Test
    public void testConvertMethodDeclaration() {
        String input = "def myMethod(self, arg):\n    return arg\n";
        grammarAmirParser parser = createParser(input);
        grammarAmirParser.ClassMethodDeclarationContext context = parser.classMethodDeclaration();
        AmirMethodDefinition method = converter.handleClassMethodDeclaration(context);
        assertNotNull(method, "Method definition should not be null");

        // Check that the parameters list size is as expected (self + arg)
        assertTrue(method.getParameters().size() == 2, "Expected two parameters");
    }


    @Test
    public void testConvertAssignmentStatement() {
        String input = "x = 5";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.statement();
        AmirStatement statement = converter.convertStatement(tree);
        assertNotNull(statement, "Statement should not be null");
        assertTrue(statement instanceof AmirDeclareAssign, "Expected an assignment statement");
    }

    @Test
    public void testConvertObjectPropertyAssignment() {
        String input = "obj.prop = 42";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.statement();
        AmirStatement statement = converter.convertStatement(tree);
        assertNotNull(statement, "Statement should not be null");
        assertTrue(statement instanceof AmirObjectPropertyAssign, "Expected an object property assignment");
    }

    @Test
    public void testConvertBinaryExpression() {
        String input = "x + y * z";
        grammarAmirParser parser = createParser(input);
        grammarAmirParser.ExpressionContext tree = parser.expression();
        AmirExpression expression = converter.convertExpression(tree);
        assertNotNull(expression, "Expression should not be null");
        assertTrue(expression instanceof AmirBinaryExpression, "Expected a binary expression");
    }

    @Test
    public void testConvertLogicalExpression() {
        String input = "x and y or not z";
        grammarAmirParser parser = createParser(input);
        grammarAmirParser.ExpressionContext tree = parser.expression();
        AmirExpression expression = converter.convertExpression(tree);
        assertNotNull(expression, "Expression should not be null");
    }

    @Test
    public void testConvertObjectMethodCall() {
        String input = "obj.method(arg1, arg2)";
        grammarAmirParser parser = createParser(input);
        grammarAmirParser.ExpressionContext tree = parser.expression();
        AmirExpression expression = converter.convertExpression(tree);
        assertNotNull(expression, "Expression should not be null");
        assertTrue(expression instanceof AmirMethodCall, "Expected a method call");
    }

    @Test
    public void testConvertObjectInstanceCreation() {
        String input = "new MyClass(arg1, arg2)";
        grammarAmirParser parser = createParser(input);
        grammarAmirParser.ExpressionContext tree = parser.expression();
        AmirExpression expression = converter.convertExpression(tree);
        assertNotNull(expression, "Expression should not be null");
        assertTrue(expression instanceof AmirObjectInstance, "Expected an object instance creation");
    }
}
