package ast;

import java.util.Map;

public class AmirObjectPropertyAssign implements AmirStatement {
    private AmirExpression targetObjectExpression; // The object whose property is being assigned
    private String propertyId; // The property identifier of the object
    private AmirExpression valueExpression; // The expression assigned to the object's property

    public AmirObjectPropertyAssign(AmirExpression targetObjectExpression, String propertyId, AmirExpression valueExpression) {
        this.targetObjectExpression = targetObjectExpression;
        this.propertyId = propertyId;
        this.valueExpression = valueExpression;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        String indentation = "    ".repeat(indentationLevel);
        return indentation + targetObjectExpression.toSourceCode(0) + "." + propertyId + " = " + valueExpression.toSourceCode(0) + "\n";
    }

    @Override
    public void execute(ExecutionContext executionContext) {

        // Evaluate the target object expression to get the address of the object
        System.out.println("Using rule: [Statement - Context rule for Object attribute assignments]");
        Object targetObjectAddress = targetObjectExpression.evaluate(executionContext);
        if (!(targetObjectAddress instanceof Integer)) {
            throw new IllegalArgumentException("Target object evaluation did not return a valid memory address.");
        }
        int objectAddress = (Integer) targetObjectAddress;

        // Evaluate the value expression to get the new value address
        Object newValue = valueExpression.evaluate(executionContext);
        if (!(newValue instanceof Integer)) {
            throw new IllegalArgumentException("Value expression evaluation did not return a valid memory address.");
        }
        int newValueAddress = (Integer) newValue;

        // Retrieve the object data from the heap using the object address
        Map<String, Integer> objectData = (Map<String, Integer>) executionContext.getHeap().retrieve(objectAddress);
        if (objectData == null) {
            throw new IllegalStateException("No object found at address " + objectAddress);
        }

        // Update the property within the object
        objectData.put(propertyId, newValueAddress);
        System.out.println("Using rule: [Statement - Reduction rule for Object attribute assignments]");
        executionContext.getHeap().update(objectAddress, objectData);
    }
}
