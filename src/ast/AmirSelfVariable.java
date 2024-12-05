package ast;

import java.util.Map;

public class AmirSelfVariable implements AmirExpression {
    private String variableName;

    public AmirSelfVariable(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        return "self." + variableName;
    }

    @Override
    public int evaluate(ExecutionContext context) {
        try {
            int currentObjectAddress = context.getCurrentObjectInstance();
            // Retrieve the object from the heap using its address
            Object objectData = context.getHeap().retrieve(currentObjectAddress);
            if (!(objectData instanceof Map)) {
                throw new RuntimeException("The object at address " + currentObjectAddress + " does not contain fields or is not a valid object.");
            }
            Map<String, Integer> fields = (Map<String, Integer>) objectData;
            if (!fields.containsKey(variableName)) {
                throw new RuntimeException("Field '" + variableName + "' not found in object at address " + currentObjectAddress);
            }
            Integer fieldAddress = fields.get(variableName);
            return fieldAddress;  // Return the address where the field value is stored in the heap
        } catch (IllegalStateException e) {
            throw new RuntimeException("Attempted to access '" + variableName + "' when no current object instance is set in context.");
        }
    }
}

