package ast;

public class AmirVariableReference implements AmirExpression {
    private String variableName;

    public AmirVariableReference(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        // Ignoring indentation as it's not relevant for variable references
        return variableName;
    }

    @Override
    public int evaluate(ExecutionContext executionContext) {
        // Fetch the address of the variable from the stack
        Integer address = executionContext.getStack().getAddress(variableName);
        if (address == null) {
            throw new RuntimeException("Variable '" + variableName + "' not found in current scope.");
        }
        return address;
    }
}
