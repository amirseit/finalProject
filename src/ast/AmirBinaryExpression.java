package ast;

public class AmirBinaryExpression implements AmirExpression {
    private AmirExpression left;
    private AmirExpression right;
    private String operator;  // Operator as a string

    public AmirBinaryExpression(AmirExpression left, AmirExpression right, String operator) {
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

        // Retrieve actual integer values from heap
        Integer leftValue = (Integer) context.getHeap().retrieve((Integer) leftResult);
        Integer rightValue = (Integer) context.getHeap().retrieve((Integer) rightResult);

        Integer operationResult; // to hold the result of the arithmetic operation

        // Perform the operation based on the operator
        switch (operator) {
            case "+":
                operationResult = leftValue + rightValue;
                break;
            case "-":
                operationResult = leftValue - rightValue;
                break;
            case "*":
                operationResult = leftValue * rightValue;
                break;
            case "/":
                if (rightValue == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                operationResult = leftValue / rightValue;  // Note: this will be integer division
                break;
            default:
                throw new RuntimeException("Unsupported operator: " + operator);
        }
        // Allocate the result to the heap and return the address
        System.out.println("Using rule: [Expression - Reduction rule for Integer Binary Operations]");
        return context.getHeap().allocate(operationResult);
    }


    @Override
    public String toSourceCode(int indentationLevel) {
        String indentation = "    ".repeat(indentationLevel);
        String leftCode = left.toSourceCode(0);
        String rightCode = right.toSourceCode(0);
        // Always add parentheses around binary or comparison expressions
        return indentation + "(" + leftCode + " " + operator + " " + rightCode + ")";
    }

}
