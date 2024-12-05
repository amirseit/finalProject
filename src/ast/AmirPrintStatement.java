package ast;

public class AmirPrintStatement implements AmirStatement {
    private AmirExpression expression;

    public AmirPrintStatement(AmirExpression expression) {
        this.expression = expression;
    }

    public AmirExpression getExpression() {
        return expression;
    }

    public void setExpression(AmirExpression expression) {
        this.expression = expression;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        String indentation = "    ".repeat(indentationLevel); // Generate the appropriate indentation

        // Return the indented print statement
        return indentation + "print(" + expression.toSourceCode(0) + ")\n";
    }

    @Override
    public void execute(ExecutionContext executionContext) {
        System.out.println("Using rule: [Statement - Context rule for Print statements]");
        Object evaluatedResult = null;
        evaluatedResult = expression.evaluate(executionContext);

        // Ensure the evaluated result is an Integer (memory address)
        if (!(evaluatedResult instanceof Integer)) {
            throw new IllegalArgumentException("Evaluation of expression did not return a valid memory address.");
        }

        Integer address = (Integer) evaluatedResult;

        // Print the value to the console
        System.out.println("Using rule: [Statement - Reduction rule for Print statements]");
        System.out.println(executionContext.getHeap().retrieve(address));
    }

}
