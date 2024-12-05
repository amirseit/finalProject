package ast;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AmirObjectInstance implements AmirExpression {
    private String className; // The name of the class being instantiated
    private List<AmirExpression> arguments; // The arguments passed to the constructor

    public AmirObjectInstance(String className, List<AmirExpression> arguments) {
        this.className = className;
        this.arguments = arguments;
    }

    public String getClassName() {
        return className;
    }

    public List<AmirExpression> getArguments() {
        return arguments;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        String args = String.join(", ", arguments.stream().map(arg -> arg.toSourceCode(0)).collect(Collectors.toList()));
        return "new " + className + "(" + args + ")";
    }

    @Override
    public int evaluate(ExecutionContext context) {
        AmirClassDefinition classDeclaration = context.getClassStore().retrieve(className);
        if (classDeclaration == null) {
            throw new RuntimeException("Class not found: " + className);
        }

        // Enter a new scope for the object
        context.getStack().enterScope();

        // Initialize fields in the new scope
        for (AmirDeclareAssign field : classDeclaration.getFields()) {
            field.execute(context);
        }

        // Execute the constructor with arguments if applicable
        if (!classDeclaration.getConstructors().isEmpty()) {
            AmirConstructorDefinition constructor = classDeclaration.getConstructors().get(0);
            List<Integer> evaluatedArgAddresses = arguments.stream()
                    .map(arg -> {
                        System.out.println("Using rule: [Expression - Context rule for object instantiation]");
                        Object result = arg.evaluate(context);
                        return (result instanceof Integer) ? (Integer) result : context.getHeap().allocate(result);
                    })
                    .collect(Collectors.toList());

            // Bind constructor parameters to object fields using the addresses from evaluated arguments
            List<AmirParameter> parameters = constructor.getParameters();
            for (int i = 1; i < parameters.size(); i++) { // Start from 1 to skip 'self'
                String paramName = parameters.get(i).getName();
                // Directly use the already allocated address for each parameter
                int address = evaluatedArgAddresses.get(i - 1);
                context.getStack().assign(paramName, address);
            }
        }

        // Retrieve all variables in the current scope as fields of the object
        Map<String, Integer> objectFields = context.getStack().getCurrentScopeVariables();
        int classNameAddress = context.getHeap().allocate(className);
        objectFields.put("__className", classNameAddress);
        int objectAddress = context.getHeap().allocate(objectFields);

        // Exit the object's scope
        context.getStack().exitScope();
        System.out.println("Using rule: [Expression - Reduction rule for object instantiation]");
        return objectAddress; // Returning the heap address of the new object
    }
}
