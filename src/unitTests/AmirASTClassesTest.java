package unitTests;

import ast.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class AmirASTClassesTest {
    ExecutionContext context;

    @BeforeEach
    public void setUp() {
        context = new ExecutionContext();
    }

    @Test
    public void testAmirDeclareAssignExecution() {
        // Create a literal expression with the value to assign
        AmirLiteral literal = new AmirLiteral(10);

        // Create the declare assign statement (not a self assignment)
        AmirDeclareAssign declareAssign = new AmirDeclareAssign("x", literal, false);

        declareAssign.execute(context);

        // Retrieve the address from the stack where the variable 'x' should be stored
        Integer address = context.getStack().getAddress("x");

        assertNotNull(address, "Address should not be null");

        // Retrieve the actual value from the heap using the address
        Object value = context.getHeap().retrieve(address);

        // Check if the value is what we assigned
        assertEquals(10, value, "Value of 'x' should be the literal value assigned");

        String sourceCode = declareAssign.toSourceCode(0);
        assertEquals("x = 10\n", sourceCode, "Source code representation should match");
    }


    @Test
    public void testAmirBinaryExpression() {
        AmirLiteral leftLiteral = new AmirLiteral(10);
        AmirLiteral rightLiteral = new AmirLiteral(5);
        AmirBinaryExpression binaryExpression = new AmirBinaryExpression(leftLiteral, rightLiteral, "+");

        int address = binaryExpression.evaluate(context);
        Object result = context.getHeap().retrieve(address);
        assertEquals(15, result);

        String sourceCode = binaryExpression.toSourceCode(0);
        assertEquals("(10 + 5)", sourceCode);
    }

    @Test
    public void testAmirLogicalExpression() {
        AmirLiteral leftBool = new AmirLiteral(true);
        AmirLiteral rightBool = new AmirLiteral(false);
        AmirLogicalExpression logicalExpression = new AmirLogicalExpression(leftBool, rightBool, "and");

        int address = logicalExpression.evaluate(context);
        Object result = context.getHeap().retrieve(address);
        assertEquals(false, result);

        // Testing the toSourceCode method
        String sourceCode = logicalExpression.toSourceCode(0);
        assertEquals("(True and False)", sourceCode);
    }


    @Test
    public void testAmirWhileLoopStructure() {
        // Create a condition and a body for the while loop
        AmirLiteral condition = new AmirLiteral(true); // This will be our loop condition
        AmirPrintStatement printStatement = new AmirPrintStatement(new AmirLiteral(123));
        List<AmirStatement> body = new ArrayList<>();
        body.add(printStatement);
        AmirWhileLoop whileLoop = new AmirWhileLoop(condition, body);

        // Check that the condition and body are set correctly
        assertEquals(condition, whileLoop.getCondition());
        assertEquals(1, whileLoop.getBody().size());

        // Check the source code representation of the while loop
        String expectedCode = "while True:\n    print(123)\n";
        String actualCode = whileLoop.toSourceCode(0);
        System.out.println(actualCode);
        assertEquals(expectedCode, actualCode, "The source code generated by toSourceCode() should match the expected output.");
    }


    @Test
    public void testAmirIfStatementWithElif() {
        // Create an 'if' condition, then block, elif conditions, and an else block
        AmirLiteral ifCondition = new AmirLiteral(true);
        AmirPrintStatement thenStatement = new AmirPrintStatement(new AmirLiteral(10));
        List<AmirStatement> thenBlock = new ArrayList<>();
        thenBlock.add(thenStatement);

        AmirLiteral elifCondition1 = new AmirLiteral(false);
        AmirPrintStatement elifStatement1 = new AmirPrintStatement(new AmirLiteral(20));
        List<AmirStatement> elifBlock1 = new ArrayList<>();
        elifBlock1.add(elifStatement1);

        AmirLiteral elifCondition2 = new AmirLiteral(true);
        AmirPrintStatement elifStatement2 = new AmirPrintStatement(new AmirLiteral(30));
        List<AmirStatement> elifBlock2 = new ArrayList<>();
        elifBlock2.add(elifStatement2);

        List<AmirIfStatement.ElifClause> elifClauses = new ArrayList<>();
        elifClauses.add(new AmirIfStatement.ElifClause(elifCondition1, elifBlock1));
        elifClauses.add(new AmirIfStatement.ElifClause(elifCondition2, elifBlock2));

        AmirPrintStatement elseStatement = new AmirPrintStatement(new AmirLiteral(40));
        AmirIfStatement.ElseClause elseBlock = new AmirIfStatement.ElseClause(List.of(elseStatement));

        AmirIfStatement ifStatement = new AmirIfStatement(ifCondition, thenBlock, elifClauses, elseBlock);

        ifStatement.execute(context);
        String expectedCode = "if True:\n    print(10)\nelif False:\n    print(20)\nelif True:\n    print(30)\nelse:\n    print(40)\n";
        String actualCode = ifStatement.toSourceCode(0);
        assertEquals(expectedCode, actualCode, "The source code generated by toSourceCode() should match the expected output.");
    }

    @Test
    public void testAmirLiteral() {
        AmirLiteral nullLiteral = new AmirLiteral(null);
        assertEquals("None", nullLiteral.toSourceCode(0), "Source code for null should be 'None'");

        int nullAddress = nullLiteral.evaluate(context);
        Object nullValue = context.getHeap().retrieve(nullAddress);
        assertNull(nullValue, "The evaluated null literal should return the heap's representation of null");
    }

    @Test
    public void testAmirNotExpression() {
        AmirLiteral trueLiteral = new AmirLiteral(true);
        AmirNotExpression notExpression = new AmirNotExpression(trueLiteral);

        int resultAddress = notExpression.evaluate(context);
        Object resultValue = context.getHeap().retrieve(resultAddress);

        assertEquals(false, resultValue, "NOT operation should invert true to false");

        String sourceCode = notExpression.toSourceCode(0);
        assertEquals("not True", sourceCode, "Source code should correctly represent NOT expression");
    }

    @Test
    public void testAmirPrintStatement() {
        AmirLiteral stringLiteral = new AmirLiteral("Hello, world!");
        AmirPrintStatement printStatement = new AmirPrintStatement(stringLiteral);

        printStatement.execute(context);  // Assuming console output can be captured or ignored in tests

        String sourceCode = printStatement.toSourceCode(0);
        assertEquals("print(\"Hello, world!\")\n", sourceCode, "Source code should match expected print syntax");
    }

    @Test
    public void testAmirCompExpression() {
        AmirLiteral leftLiteral = new AmirLiteral(10);
        AmirLiteral rightLiteral = new AmirLiteral(5);
        AmirCompExpression compExpression = new AmirCompExpression(leftLiteral, rightLiteral, ">");

        int resultAddress = compExpression.evaluate(context);
        Object resultValue = context.getHeap().retrieve(resultAddress);

        assertEquals(true, resultValue, "Comparison should evaluate to true for 10 > 5");

        String sourceCode = compExpression.toSourceCode(0);
        assertEquals("(10 > 5)", sourceCode, "Source code should correctly represent the comparison expression");
    }

    @Test
    public void testAmirVariableReference() {
        context.getStack().assign("y", context.getHeap().allocate(42));
        AmirVariableReference varRef = new AmirVariableReference("y");

        int address = varRef.evaluate(context);
        Object value = context.getHeap().retrieve(address);

        assertEquals(42, value, "Variable reference should retrieve correct value from context");

        String sourceCode = varRef.toSourceCode(0);
        assertEquals("y", sourceCode, "Source code should simply return the variable name");
    }

    @Test
    public void testAmirSelfVariable() {
        Map<String, Integer> objectData = new HashMap<>();

        // Allocate space for the field value in the heap and get its address
        int fieldValue = 789;
        int fieldAddress = context.getHeap().allocate(fieldValue);
        objectData.put("testField", fieldAddress);

        // Allocate the object in the heap and set it as the current object instance
        int objectAddress = context.getHeap().allocate(objectData);
        context.pushCurrentObjectInstance(objectAddress);

        AmirSelfVariable selfVariable = new AmirSelfVariable("testField");

        // Evaluate should return the address
        int retrievedFieldAddress = selfVariable.evaluate(context);
        Object retrievedFieldValue = context.getHeap().retrieve(retrievedFieldAddress);

        // Assertions to verify that the field value is correctly retrieved from the object
        assertEquals(fieldAddress, retrievedFieldAddress, "Self variable should retrieve correct field address");
        assertEquals(fieldValue, retrievedFieldValue, "Self variable should retrieve correct field value");

        String sourceCode = selfVariable.toSourceCode(0);
        assertEquals("self.testField", sourceCode, "Source code representation should match");
    }

    @Test
    public void testAmirReturnStatement() {
        AmirLiteral returnValue = new AmirLiteral(123);
        AmirReturnStatement returnStatement = new AmirReturnStatement(returnValue);

        int returnValueAddress = returnStatement.evaluate(context);
        Object returnedValue = context.getHeap().retrieve(returnValueAddress);

        assertEquals(123, returnedValue, "The return value should be 123");
        String sourceCode = returnStatement.toSourceCode(0);
        assertEquals("return 123\n", sourceCode, "Source code representation should match");
    }

    @Test
    public void testAmirSelfReference() {
        Map<String, Integer> objectData = new HashMap<>();
        int propertyValue = 789;
        int propertyAddress = context.getHeap().allocate(propertyValue); // Allocate property value on the heap
        objectData.put("testProperty", propertyAddress);

        // Allocate the object in the heap and set it as the current object instance
        int testObjectAddress = context.getHeap().allocate(objectData);
        context.pushCurrentObjectInstance(testObjectAddress);

        AmirSelfReference selfReference = new AmirSelfReference();

        // Evaluate should return the address of the current object instance
        int retrievedObjectAddress = selfReference.evaluate(context);
        assertEquals(testObjectAddress, retrievedObjectAddress, "Self reference should return the current object's address");

        // Retrieve the object map from the heap
        Map<String, Integer> retrievedObjectData = (Map<String, Integer>) context.getHeap().retrieve(retrievedObjectAddress);
        assertNotNull(retrievedObjectData, "The object data should be retrieved from the heap");
        assertTrue(retrievedObjectData.containsKey("testProperty"), "The object should contain the testProperty");
        assertEquals(propertyValue, context.getHeap().retrieve(retrievedObjectData.get("testProperty")), "The property value should be correctly retrieved from the heap");

        String sourceCode = selfReference.toSourceCode(0);
        assertEquals("self", sourceCode, "Source code representation should match");
    }

}
