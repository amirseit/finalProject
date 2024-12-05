package ast;

import java.util.List;

public class AmirWhileLoop implements AmirStatement {
    private AmirExpression condition;
    private List<AmirStatement> body;

    public AmirWhileLoop(AmirExpression condition, List<AmirStatement> body) {
        this.condition = condition;
        this.body = body;
    }

    public AmirExpression getCondition() {
        return condition;
    }

    public void setCondition(AmirExpression condition) {
        this.condition = condition;
    }

    public List<AmirStatement> getBody() {
        return body;
    }

    public void setBody(List<AmirStatement> body) {
        this.body = body;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        StringBuilder sb = new StringBuilder();
        String indentation = "    ".repeat(indentationLevel); // Generate the appropriate indentation

        // Append the while loop declaration with indentation
        sb.append(indentation).append("while ").append(condition.toSourceCode(0)).append(":\n");

        // Check if the body is not empty and add each statement with an increased indentation level
        if (body != null && !body.isEmpty()) {
            for (AmirStatement statement : body) {
                sb.append(statement.toSourceCode(indentationLevel + 1)); // Increase indentation for the body
            }
        } else {
            // If the body is empty, add a 'pass' statement with increased indentation
            sb.append(indentation).append("    pass\n");
        }

        return sb.toString();
    }

    @Override
    public void execute(ExecutionContext executionContext) {
        // Continuously evaluate the condition; execute the body as long as the condition is true

        while (evaluateCondition(executionContext)) {
            for (AmirStatement statement : body) {
                System.out.println("Using rule: [Statement - Reduction rule for While loops (true)]");
                statement.execute(executionContext);
            }
        }
        System.out.println("Using rule: [Statement - Reduction rule for While loops (false)]");
    }

    private boolean evaluateCondition(ExecutionContext executionContext) {
        // Evaluate the condition expression and ensure it returns a Boolean
        System.out.println("Using rule: [Statement - Context rule for While loops]");
        Object evaluatedResult = condition.evaluate(executionContext);

        // Ensure the evaluated result is an Integer (memory address)
        if (!(evaluatedResult instanceof Integer)) {
            throw new IllegalArgumentException("Evaluation of expression did not return a valid memory address.");
        }

        Integer address = (Integer) evaluatedResult;
        Object result = executionContext.getHeap().retrieve(address);
        if (!(result instanceof Boolean)) {
            throw new IllegalArgumentException("While loop condition did not evaluate to a boolean value");
        }
        return (Boolean) result;
    }

}
