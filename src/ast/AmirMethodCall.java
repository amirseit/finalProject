package ast;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AmirMethodCall implements AmirExpression {
    private AmirExpression object;
    private String methodName;
    private List<AmirExpression> arguments;

    public AmirMethodCall(AmirExpression object, String methodName, List<AmirExpression> arguments) {
        this.object = object;
        this.methodName = methodName;
        this.arguments = arguments;
    }

    public AmirExpression getObject() {
        return object;
    }

    public String getMethodName() {
        return methodName;
    }

    public List<AmirExpression> getArguments() {
        return arguments;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        String args = arguments.stream()
                .map(arg -> arg.toSourceCode(0))
                .collect(Collectors.joining(", "));
        return object.toSourceCode(0) + "." + methodName + "(" + args + ")";
    }

    @Override
    public int evaluate(ExecutionContext context) {
        // Evaluate the object expression to get the object's address in the heap
        System.out.println("Using rule: [Expression - Context rule for object method call (ex)]");
        Object obj = object.evaluate(context);
        if (!(obj instanceof Integer)) {
            throw new RuntimeException("Object address not returned correctly.");
        }
        int address = (Integer) obj;
        context.pushCurrentObjectInstance(address);
        // Retrieve the object from the heap using its address, which should include class information
        Map<String, Integer> retrievedObject = (Map<String, Integer>) context.getHeap().retrieve(address);
        if (retrievedObject == null || !retrievedObject.containsKey("__className")) {
            throw new RuntimeException("Object does not contain class information.");
        }

        int classNameAddress = retrievedObject.get("__className");
        String className = (String) context.getHeap().retrieve(classNameAddress);
        if (className == null) {
            throw new RuntimeException("Class name not found in heap.");
        }

        AmirClassDefinition classDeclaration = context.getClassStore().retrieve(className);
        if (classDeclaration == null) {
            throw new RuntimeException("Class '" + className + "' not found.");
        }

        AmirMethodDefinition methodDeclaration = classDeclaration.getMethods().stream()
                .filter(m -> m.getName().equals(methodName))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Method '" + methodName + "' not found in class '" + className + "'"));

        // Evaluate arguments
        List<Integer> evaluatedArgAddresses = arguments.stream()
                .map(arg -> {
                    System.out.println("Using rule: [Expression - Context rule for object method call (e0)]");
                    Object result = arg.evaluate(context);
                    return (result instanceof Integer) ? (Integer) result : context.getHeap().allocate(result);
                })
                .collect(Collectors.toList());

        if (evaluatedArgAddresses.size() > methodDeclaration.getParameters().size() - 1) {
            throw new IllegalArgumentException("Too many arguments provided for method '" + methodName + "'. Expected " + (methodDeclaration.getParameters().size() - 1) + " arguments.");
        }
        // Enter a new scope for the method execution
        context.getStack().enterScope();
        try {
            // Bind parameters and arguments in the new method scope
            List<AmirParameter> parameters = methodDeclaration.getParameters();
            for (int i = 1; i < parameters.size(); i++) {
                String paramName = parameters.get(i).getName();
                // Directly use the already allocated address for each parameter
                int addressParam = evaluatedArgAddresses.get(i - 1);
                context.getStack().assign(paramName, addressParam);
            }

            // Execute method body
            for (AmirStatement statement : methodDeclaration.getBody()) {
                statement.execute(context);
            }
            System.out.println("Using rule: [Expression - Reduction rule for object method call]");
            return methodDeclaration.getReturnStatement().evaluate(context);
        } finally {
            // Exit the scope after method execution
            context.getStack().exitScope();
            context.popCurrentObjectInstance();
        }
    }

}
