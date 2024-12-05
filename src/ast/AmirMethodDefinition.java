package ast;

import java.util.List;
import java.util.stream.Collectors;

public class AmirMethodDefinition implements AmirDefinition {
    private String name;
    private List<AmirParameter> parameters; // List of parameter names
    private List<AmirStatement> body; // The body of the method
    private AmirReturnStatement returnStatement; // The return statement of the method

    // Constructor including return statement
    public AmirMethodDefinition(String name, List<AmirParameter> parameters, List<AmirStatement> body, AmirReturnStatement returnStatement) {
        this.name = name;
        this.parameters = parameters;
        this.body = body;
        this.returnStatement = returnStatement;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AmirParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<AmirParameter> parameters) {
        this.parameters = parameters;
    }

    public List<AmirStatement> getBody() {
        return body;
    }

    public void setBody(List<AmirStatement> body) {
        this.body = body;
    }

    public AmirReturnStatement getReturnStatement() {
        return returnStatement;
    }

    public void setReturnStatement(AmirReturnStatement returnStatement) {
        this.returnStatement = returnStatement;
    }

    // Representation in source code
    @Override
    public String toSourceCode(int indentationLevel) {
        StringBuilder sb = new StringBuilder();
        String indentation = "    ".repeat(indentationLevel);

        sb.append(indentation).append("def ").append(name).append("(");
        sb.append(parameters.stream().map(AmirParameter::toSourceCode).collect(Collectors.joining(", ")));
        sb.append("):\n");

        if (body.isEmpty() && returnStatement == null) {
            sb.append(indentation).append("    pass\n");
        } else {
            body.forEach(statement -> sb.append(statement.toSourceCode(indentationLevel + 1)));
            if (returnStatement != null) {
                sb.append(returnStatement.toSourceCode(indentationLevel + 1));
            }
        }

        return sb.toString();
    }

    @Override
    public void define(ExecutionContext executionContext) {
        System.out.println("Definition method for AmirMethodDefinition start");
        System.out.println("Definition method for AmirMethodDefinition finish");
    }
}

