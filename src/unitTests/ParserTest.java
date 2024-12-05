package unitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;
import parser.grammarAmirLexer;
import parser.grammarAmirParser;

public class ParserTest {

    private grammarAmirParser createParser(String input) {
        grammarAmirLexer lexer = new grammarAmirLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new grammarAmirParser(tokens);
    }

    @Test
    public void testEmptyProgram() {
        String input = "";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.program();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);
        assertEquals("(program <EOF>)", tree.toStringTree(parser), "Expected empty program");
    }

    @Test
    public void testSimpleClassDeclaration() {
        String input = "class MyClass:";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.classDeclaration();
        assertTrue(tree.toStringTree(parser).contains("MyClass"), "Expected class declaration to include 'MyClass'");
    }


    @Test
    public void testIfElifElseStatement() {
        String input = "if (x > 0):\n    print x\nelif (x < 0):\n    print 5\nelse:\n    print 0\n";

        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.ifStatement();
        String treeString = tree.toStringTree(parser);

        System.out.println(treeString);

        assertTrue(treeString.contains("(atom x)"), "Expected 'x' in conditions");
        assertTrue(treeString.contains(">"), "Expected '>' operator in if condition");
        assertTrue(treeString.contains("<"), "Expected '<' operator in elif condition");
        assertTrue(treeString.contains("(printStatement print (expression (atom x)))"), "Expected 'print x' in if statement block");
        assertTrue(treeString.contains("(printStatement print (expression (atom 5)))"), "Expected 'print 5' in elif statement block");
        assertTrue(treeString.contains("(printStatement print (expression (atom 0)))"), "Expected 'print 0' in else statement block");
    }



    @Test
    public void testWhileStatement() {
        // Use the boolean "true" for simplicity
        String input = "while (true):\n    print(123)\n";

        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.whileStatement();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        assertTrue(treeString.contains("true"), "Expected 'true' in while condition");
        assertTrue(treeString.contains("print"), "Expected 'print' in while body");
        assertTrue(treeString.contains("123"), "Expected '123' in while body");
    }

    @Test
    public void testPrintStatement() {
        String input = "print 123\n";

        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.printStatement();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        assertTrue(treeString.contains("print"), "Expected 'print' keyword in the parse tree");
        assertTrue(treeString.contains("123"), "Expected '123' as the expression in the print statement");
    }

    @Test
    public void testAssignmentStatement() {
        String input = "variable = 13";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.assignment();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        assertTrue(treeString.contains("variable"), "Expected variable in assignment");
        assertTrue(treeString.contains("13"), "Expected '13' as assignment value");
    }

    @Test
    public void testMethodCallExpression() {
        String input = "object.method(arg1, arg2)";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.expression();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        assertTrue(treeString.contains("method"), "Expected method name in expression");
        assertTrue(treeString.contains("arg1"), "Expected 'arg1' in method arguments");
        assertTrue(treeString.contains("arg2"), "Expected 'arg2' in method arguments");
    }

    @Test
    public void testClassInstantiationExpression() {
        String input = "new MyClass(arg1)";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.expression();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        assertTrue(treeString.contains("MyClass"), "Expected class name in instantiation");
        assertTrue(treeString.contains("arg1"), "Expected 'arg1' as constructor argument");
    }

    @Test
    public void testConstructorDeclaration() {
        String input = "def __init__(self, param1):\n    self.param1 = param1\n";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.constructorDeclaration();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        assertTrue(treeString.contains("__init__"), "Expected constructor name");
        assertTrue(treeString.contains("param1"), "Expected 'param1' as a parameter");
        assertTrue(treeString.contains("(assignment self.param1 = (expression (atom param1))))"), "Expected this as constructor body");
    }

    @Test
    public void testClassMethodDeclaration() {
        String input = "def myMethod(self, param):\n    return param * 2\n";
        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.classMethodDeclaration();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        assertTrue(treeString.contains("myMethod"), "Expected method name");
        assertTrue(treeString.contains("param"), "Expected 'param' as a parameter");
        assertTrue(treeString.contains("*"), "Expected multiplication operation in return");
    }

    @Test
    public void testComplexExpression() {
        String input = "((x > 5) and (y < 10) or not z)";

        grammarAmirParser parser = createParser(input);
        ParseTree tree = parser.expression();
        String treeString = tree.toStringTree(parser);
        System.out.println(treeString);

        assertTrue(treeString.contains("(atom x)"), "Expected 'x' in expression");
        assertTrue(treeString.contains(">"), "Expected '>' operator");
        assertTrue(treeString.contains("5"), "Expected '5'");
        assertTrue(treeString.contains("(atom y)"), "Expected 'y' in expression");
        assertTrue(treeString.contains("<"), "Expected '<' operator");
        assertTrue(treeString.contains("10"), "Expected '10'");
        assertTrue(treeString.contains("not"), "Expected 'not' operator");
        assertTrue(treeString.contains("(atom z)"), "Expected 'z' in expression");
    }
}
