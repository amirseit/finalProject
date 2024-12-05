package ast;

import java.util.List;
import java.util.stream.Collectors;

public class AmirConstructorDefinition implements AmirDefinition {
    private List<AmirParameter> parameters; // List of parameter names
    private List<AmirDeclareAssign> body; // The body of the method

    public AmirConstructorDefinition(List<AmirParameter> parameters, List<AmirDeclareAssign> body) {
        this.parameters = parameters;
        this.body = body;
    }

    public List<AmirParameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<AmirParameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        StringBuilder sb = new StringBuilder();
        String indentation = "    ".repeat(indentationLevel);

        sb.append(indentation).append("def __init__(");
        sb.append(parameters.stream().map(AmirParameter::toSourceCode).collect(Collectors.joining(", ")));
        sb.append("):\n");

        if (body.isEmpty()) {
            sb.append(indentation).append("    pass\n");
        } else {
            body.forEach(statement -> sb.append(statement.toSourceCode(indentationLevel + 1)));
        }

        return sb.toString();
    }

    @Override
    public void define(ExecutionContext executionContext) {
        System.out.println("Definition method for AmirConstructorDefinition start");
        System.out.println("Definition method for AmirConstructorDefinition finish");
    }

}
