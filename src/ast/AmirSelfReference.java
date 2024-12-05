package ast;

import java.util.Map;

public class AmirSelfReference implements AmirExpression {

    @Override
    public String toSourceCode(int indentationLevel) {
        return "self";
    }

    @Override
    public int evaluate(ExecutionContext context) {
        try {
            int currentObjectAddress = context.getCurrentObjectInstance();
            return currentObjectAddress;
        } catch (IllegalStateException e) {
            throw new RuntimeException("Reference to 'self' is invalid outside of class method context.");
        }
    }
}

