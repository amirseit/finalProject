package ast;

public interface AmirExpression extends AmirAST{
    int evaluate(ExecutionContext executionContext);
}

//all expressions should be evaluated