package ast;

public class AmirLiteral implements AmirExpression {
    private Object value; // Can be Integer, String, Boolean, or null

    public AmirLiteral(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        if (value == null) {
            return "None";
        } else if (value instanceof String) {
            return "\"" + value + "\"";  // Adds quotes around strings for output
        } else if (value instanceof Boolean) {
            return value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1).toLowerCase();
        } else {
            return value.toString();  // Direct conversion for integers, floats, and other types
        }
    }

    @Override
    public int evaluate(ExecutionContext executionContext) {
        if (value == null) {
            System.out.println("Using rule: [Expression - Reduction rule for basic immutable values on the heap]");
            return 2; // Address of None
        } else if (value instanceof Boolean) {
            System.out.println("Using rule: [Expression - Reduction rule for basic immutable values on the heap]");
            return (Boolean) value ? 0 : 1; // Addresses for True and False
        } else {
            System.out.println("Using rule: [Expression - Reduction rule for basic values on the heap]");
            return executionContext.getHeap().allocate(value);
        }
    }
}
