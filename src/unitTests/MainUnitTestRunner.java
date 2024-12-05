package unitTests;

import org.junit.jupiter.api.Test;

public class MainUnitTestRunner {

    @Test
    public void runLexerTests() {
        LexerTest lexerTest = new LexerTest();
        lexerTest.testOperators();
        lexerTest.testComparisonOperators();
        lexerTest.testStringLiterals();
        lexerTest.testIntegerLiterals();
        lexerTest.testIdentifiers();
        lexerTest.testSelfIdentifiers();
        lexerTest.testNewlines();
        lexerTest.testWhitespace();
    }

    @Test
    public void runParserTests() {
        ParserTest parserTest = new ParserTest();
        parserTest.testEmptyProgram();
        parserTest.testSimpleClassDeclaration();
        parserTest.testIfElifElseStatement();
        parserTest.testWhileStatement();
        parserTest.testPrintStatement();
        parserTest.testAssignmentStatement();
        parserTest.testMethodCallExpression();
        parserTest.testClassInstantiationExpression();
        parserTest.testConstructorDeclaration();
        parserTest.testClassMethodDeclaration();
        parserTest.testComplexExpression();
    }

    @Test
    public void runCSTtoASTConverterTests() {
        CSTtoASTConverterTest cstToAstConverterTest = new CSTtoASTConverterTest();
        cstToAstConverterTest.setUp();
        cstToAstConverterTest.testConvertEmptyProgram();
        cstToAstConverterTest.testConvertWhileStatement();
        cstToAstConverterTest.testConvertIfStatement();
        cstToAstConverterTest.testConvertPrintStatement();
        cstToAstConverterTest.testExpressionConversion();
        cstToAstConverterTest.testConvertClassDefinition();
        cstToAstConverterTest.testConvertMethodDeclaration();
        cstToAstConverterTest.testConvertAssignmentStatement();
        cstToAstConverterTest.testConvertObjectPropertyAssignment();
        cstToAstConverterTest.testConvertBinaryExpression();
        cstToAstConverterTest.testConvertLogicalExpression();
        cstToAstConverterTest.testConvertObjectMethodCall();
        cstToAstConverterTest.testConvertObjectInstanceCreation();
    }

    @Test
    public void runAmirASTClassesTests() {
        AmirASTClassesTest amirAstClassesTest = new AmirASTClassesTest();
        amirAstClassesTest.setUp();
        amirAstClassesTest.testAmirDeclareAssignExecution();
        amirAstClassesTest.testAmirBinaryExpression();
        amirAstClassesTest.testAmirLogicalExpression();
        amirAstClassesTest.testAmirWhileLoopStructure();
        amirAstClassesTest.testAmirIfStatementWithElif();
        amirAstClassesTest.testAmirLiteral();
        amirAstClassesTest.testAmirNotExpression();
        amirAstClassesTest.testAmirPrintStatement();
        amirAstClassesTest.testAmirCompExpression();
        amirAstClassesTest.testAmirVariableReference();
        amirAstClassesTest.testAmirSelfVariable();
        amirAstClassesTest.testAmirReturnStatement();
        amirAstClassesTest.testAmirSelfReference();
    }
}

