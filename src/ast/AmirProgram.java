package ast;

import java.util.List;

public class AmirProgram implements AmirAST{
    private List<AmirDefinition> definitions;
    private List<AmirStatement> statements;
    private ExecutionContext executionContext;

    public AmirProgram(List<AmirDefinition> definitions, List<AmirStatement> statements) {
        this.definitions = definitions;
        this.statements = statements;
        this.executionContext = new ExecutionContext(); // Initialize the variable store
    }

    public List<AmirStatement> getStatements() {
        return statements;
    }
    public List<AmirDefinition> getDefinitions() {
        return definitions;
    }
    public void setStatements(List<AmirStatement> statements) {
        this.statements = statements;
    }

    public ExecutionContext getExecutionContext() {
        return executionContext;
    }

    public void setExecutionContext(ExecutionContext executionContext) {
        this.executionContext = executionContext;
    }

    public String toSourceCode(int indentationLevel) {
        StringBuilder sourceCode = new StringBuilder();
        for (AmirDefinition definition : definitions) {
            sourceCode.append(definition.toSourceCode(indentationLevel)).append("\n");
        }
        for (AmirStatement statement : statements) {
            sourceCode.append(statement.toSourceCode(indentationLevel)).append("\n");
        }
        return sourceCode.toString();
    }

    public void execute() {
        System.out.println("Execute method for AmirProgram start");
        for (AmirDefinition definition : definitions) {
            definition.define(this.executionContext); // Pass the variable store to each statement
        }
        for (AmirStatement statement : statements) {
            statement.execute(this.executionContext); // Pass the variable store to each statement
        }
        System.out.println("Execute method for AmirProgram finish");
    }

}
