package ast;

import java.util.Map;

public class AmirFieldAccess implements AmirExpression {
    private AmirExpression object; // The object from which the field is being accessed
    private String fieldName; // The name of the field being accessed
    public AmirFieldAccess(AmirExpression object, String fieldName) {
        this.object = object;
        this.fieldName = fieldName;
    }

    public AmirExpression getObject() {
        return object;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        return object.toSourceCode(0) + "." + fieldName;
    }

    @Override
    public int evaluate(ExecutionContext context) {

        // First, evaluate the object expression to get the object's address in the heap
        System.out.println("Using rule: [Expression - Context rule for object attribute access]");
        Object obj = object.evaluate(context);
        if (!(obj instanceof Integer)) {
            throw new RuntimeException("Object address not returned correctly.");
        }

        // Retrieve the object from the heap using its address
        int address = (Integer) obj;
        Object retrievedObject = context.getHeap().retrieve(address);

        if (!(retrievedObject instanceof Map)) {
            throw new RuntimeException("Expected an object (map) at address " + address);
        }

        @SuppressWarnings("unchecked")
        Map<String, Integer> fieldMap = (Map<String, Integer>) retrievedObject;

        // Access the field from the object
        if (!fieldMap.containsKey(fieldName)) {
            throw new RuntimeException("Field '" + fieldName + "' not found in object.");
        }

        Integer fieldAddress = fieldMap.get(fieldName);
        // Retrieve the field value from the heap
        System.out.println("Using rule: [Expression - Reduction rule for object attribute access]");
        return fieldAddress;
    }
}
