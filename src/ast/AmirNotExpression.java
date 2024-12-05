package ast;

public class AmirNotExpression implements AmirExpression {
    private AmirExpression operand;  // The operand to negate

    public AmirNotExpression(AmirExpression operand) {
        this.operand = operand;
    }

    @Override
    public int evaluate(ExecutionContext context) {
        System.out.println("Using rule: [Expression - Context rule for Not Unary Operations]");
        Object operandResult = operand.evaluate(context);

        // Ensure the operand is an address before retrieving the value from the heap
        if (!(operandResult instanceof Integer)) {
            throw new IllegalArgumentException("Operand must be a memory address.");
        }

        Boolean operandBool = (Boolean) context.getHeap().retrieve((Integer) operandResult);
        boolean logicalResult = !operandBool;  // Perform the NOT operation

        // Return the pre-allocated memory address for true or false
        System.out.println("Using rule: [Expression - Reduction rule for Not Unary Operations]");
        return logicalResult ? 0 : 1; // Assuming 0 is memory address for true, 1 for false
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        String indentation = "    ".repeat(indentationLevel);
        String operandCode = operand.toSourceCode(0);
        // NOT operation is unary, so we only need to prefix the operation to the operand
        return indentation + "not " + operandCode;
    }
}
