package ast;

public interface AmirStatement extends AmirAST{
    void execute(ExecutionContext executionContext);
}
