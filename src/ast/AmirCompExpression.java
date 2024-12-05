package ast;

public class AmirCompExpression implements AmirExpression {
    private AmirExpression left;
    private AmirExpression right;
    private String operator;  // Operator for comparison

    public AmirCompExpression(AmirExpression left, AmirExpression right, String operator) {
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

        boolean comparisonResult;

        // Perform the comparison based on the operator
        switch (operator) {
            case "==":
                comparisonResult = leftValue.equals(rightValue);
                break;
            case "!=":
                comparisonResult = !leftValue.equals(rightValue);
                break;
            case "<":
                comparisonResult = leftValue < rightValue;
                break;
            case ">":
                comparisonResult = leftValue > rightValue;
                break;
            case "<=":
                comparisonResult = leftValue <= rightValue;
                break;
            case ">=":
                comparisonResult = leftValue >= rightValue;
                break;
            default:
                throw new RuntimeException("Unsupported comparison operator: " + operator);
        }

        // Return the pre-allocated memory address for true or false
        System.out.println("Using rule: [Expression - Reduction rule for Comparison Binary Operations]");
        return comparisonResult ? 0 : 1;
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
