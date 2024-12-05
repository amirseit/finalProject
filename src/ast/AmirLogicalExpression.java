package ast;

public class AmirLogicalExpression implements AmirExpression {
    private AmirExpression left;
    private AmirExpression right;
    private String operator;  // Operator for logical operations ("and", "or")

    public AmirLogicalExpression(AmirExpression left, AmirExpression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public int evaluate(ExecutionContext context) {
        System.out.println("Using rule: [Expression - Context rule for Binary Operations (e1)]");
        Object leftResult = left.evaluate(context);
        System.out.println("Using rule: [Expression - Context rule for Binary Operations (e2)]");
        Object rightResult = right.evaluate(context);

        // Ensure both operands are addresses before retrieving the values from the heap
        if (!(leftResult instanceof Integer && rightResult instanceof Integer)) {
            throw new IllegalArgumentException("Both operands must be memory addresses.");
        }

        Boolean leftBool = (Boolean) context.getHeap().retrieve((Integer) leftResult);
        Boolean rightBool = (Boolean) context.getHeap().retrieve((Integer) rightResult);
        boolean logicalResult;

        // Perform the logical operation based on the operator
        switch (operator) {
            case "and":
                logicalResult = leftBool && rightBool;
                break;
            case "or":
                logicalResult = leftBool || rightBool;
                break;
            default:
                throw new RuntimeException("Unsupported logical operator: " + operator);
        }

        // Return the pre-allocated memory address for true or false
        System.out.println("Using rule: [Expression - Reduction rule for Logical Binary Operations]");
        return logicalResult ? 0 : 1; // Assuming 0 is memory address for true, 1 for false
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        String indentation = "    ".repeat(indentationLevel);
        String leftCode = left.toSourceCode(0);
        String rightCode = right.toSourceCode(0);
        // Always add parentheses around logical expressions
        return indentation + "(" + leftCode + " " + operator + " " + rightCode + ")";
    }
}
