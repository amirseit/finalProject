package ast;

public class AmirReturnStatement implements AmirStatement {
    private AmirExpression returnValueExpression;

    public AmirReturnStatement(AmirExpression returnValueExpression) {
        this.returnValueExpression = returnValueExpression;
    }

    public AmirExpression getReturnValueExpression() {
        return returnValueExpression;
    }

    public void setReturnValueExpression(AmirExpression returnValueExpression) {
        this.returnValueExpression = returnValueExpression;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        String indentation = "    ".repeat(indentationLevel);
        return indentation + "return " + (returnValueExpression != null ? returnValueExpression.toSourceCode(0) : "") + "\n";
    }

    @Override
    public void execute(ExecutionContext executionContext) {
        // The execute method is not used directly for return statements in the context of function/method execution.
        // The actual return behavior is handled in the function/method execution logic (e.g., AmirFunctionCall.evaluate).
    }

    public int evaluate(ExecutionContext executionContext) {
        return returnValueExpression != null ? returnValueExpression.evaluate(executionContext) : 2;
    }
}
