package ast;

import java.util.Map;

public class AmirDeclareAssign implements AmirStatement {
    private String id; // Identifier for the variable being assigned
    private AmirExpression expression; // The expression assigned to the variable
    private boolean isSelfAssignment; // Flag to check if it's an assignment to a self variable

    public AmirDeclareAssign(String id, AmirExpression expression, boolean isSelfAssignment) {
        this.id = id;
        this.expression = expression;
        this.isSelfAssignment = isSelfAssignment;
    }

    public String getId() {
        return id;
    }

    public AmirExpression getExpression() {
        return expression;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExpression(AmirExpression expression) {
        this.expression = expression;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        String prefix = isSelfAssignment ? "self." : "";
        String indentation = "    ".repeat(indentationLevel);
        return indentation + prefix + id + " = " + expression.toSourceCode(0) + "\n";
    }

    public void execute(ExecutionContext executionContext) {

        // Evaluate the expression to get the new address (or directly the address for a variable reference)
        System.out.println("Using rule: [Statement - Context rule for Variable declarations or assignments]");
        Object evaluatedResult = expression.evaluate(executionContext);

        if (!(evaluatedResult instanceof Integer)) {
            throw new IllegalArgumentException("Evaluation of expression did not return a valid memory address.");
        }

        Integer newValueAddress = (Integer) evaluatedResult;

        if (isSelfAssignment) {
            // Handling self field assignment
            int currentObjectAddress = executionContext.getCurrentObjectInstance();
            Map<String, Integer> objectData = (Map<String, Integer>) executionContext.getHeap().retrieve(currentObjectAddress);
            objectData.put(id, newValueAddress); //updates stack addresses
            System.out.println("Using rule: [Statement - Reduction rule for Object attribute assignments]");
            executionContext.getHeap().update(currentObjectAddress, objectData);
        } else {
            // Handling normal variable assignment
            Integer existingAddress = executionContext.getStack().getAddress(id);
            if (existingAddress != null) {
                System.out.println("Using rule: [Statement - Reduction rule for Variable declarations or assignments]");
                executionContext.getStack().assign(id, newValueAddress);
            } else {
                System.out.println("Using rule: [Statement - Reduction rule for Variable declarations or assignments]");
                executionContext.getStack().assign(id, newValueAddress);
            }
        }

    }
}

