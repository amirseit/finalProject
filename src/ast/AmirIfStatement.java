package ast;

import java.util.List;

public class AmirIfStatement implements AmirStatement {
    private AmirExpression condition;
    private List<AmirStatement> thenBlock; // A list of statements for the 'if' block
    private List<ElifClause> elifClauses; // A list to hold 'elif' clauses
    private ElseClause elseBlock; // Now using ElseClause for the 'else' block

    // Constructor
    public AmirIfStatement(AmirExpression condition, List<AmirStatement> thenBlock, List<ElifClause> elifClauses, ElseClause elseBlock) {
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elifClauses = elifClauses;
        this.elseBlock = elseBlock;
    }

    // Getters and setters
    public AmirExpression getCondition() {
        return condition;
    }

    public void setCondition(AmirExpression condition) {
        this.condition = condition;
    }

    public List<AmirStatement> getThenBlock() {
        return thenBlock;
    }

    public void setThenBlock(List<AmirStatement> thenBlock) {
        this.thenBlock = thenBlock;
    }

    public List<ElifClause> getElifClauses() {
        return elifClauses;
    }

    public void setElifClauses(List<ElifClause> elifClauses) {
        this.elifClauses = elifClauses;
    }

    public ElseClause getElseBlock() {
        return elseBlock;
    }

    public void setElseBlock(ElseClause elseBlock) {
        this.elseBlock = elseBlock;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        StringBuilder sb = new StringBuilder();
        String indentation = "    ".repeat(indentationLevel);

        // if part
        sb.append(indentation).append("if ").append(condition.toSourceCode(0)).append(":\n");
        for (AmirStatement statement : thenBlock) {
            sb.append(statement.toSourceCode(indentationLevel + 1));
        }

        // elif clauses
        for (ElifClause elifClause : elifClauses) {
            sb.append(elifClause.toSourceCode(indentationLevel));
        }

        // else part
        if (elseBlock != null) {
            sb.append(indentation).append("else:\n"); // Correctly place the else keyword with indentation
            sb.append(elseBlock.toSourceCode(indentationLevel + 1)); // Indent the block content properly
        }


        return sb.toString();
    }

    @Override
    public void execute(ExecutionContext executionContext) {
        boolean check = false;
        System.out.println("Using rule: [Statement - Context rule for If statements]");
        if (evaluateCondition(condition, executionContext)) {
            System.out.println("Using rule: [Statement - Reduction rule for If statement (true)]");
            check = true;
            executeStatements(thenBlock, executionContext);
        } else {
            boolean executedElif = false;
            // Check each elif clause, execute the first one that evaluates to true
            for (ElifClause elifClause : elifClauses) {
                System.out.println("Using rule: [Statement - Reduction rule for If statement (false)]");
                if (elifClause.evaluateCondition(elifClause.getCondition(), executionContext)) {
                    check = true;
                    System.out.println("Using rule: [Statement - Reduction rule for If statement (true)]");
                    elifClause.executeStatements(elifClause.getStatementBlock(), executionContext);
                    executedElif = true;
                    break; // Break after executing the first true elif block
                }
            }
            // If no if or elif conditions were true, execute the else block
            if (!executedElif && elseBlock != null) {
                check = true;
                System.out.println("Using rule: [Statement - Reduction rule for If statement (else)]");
                elseBlock.executeStatements(elseBlock.getStatementBlock(), executionContext);
            }
        }
        if(!check){
            System.out.println("Using rule: [Statement - Reduction rule for If statement (false, no else)]");
        }
    }

    private boolean evaluateCondition(AmirExpression condition, ExecutionContext executionContext) {
        Object evaluatedResult = condition.evaluate(executionContext);

        // Ensure the evaluated result is an Integer (memory address)
        if (!(evaluatedResult instanceof Integer)) {
            throw new IllegalArgumentException("Evaluation of expression did not return a valid memory address.");
        }

        Integer address = (Integer) evaluatedResult;
        Object result = executionContext.getHeap().retrieve(address);
        if (!(result instanceof Boolean)) {
            throw new IllegalArgumentException("Condition did not evaluate to a boolean value");
        }
        return (Boolean) result;
    }

    private void executeStatements(List<AmirStatement> statements, ExecutionContext executionContext) {
        for (AmirStatement statement : statements) {
            statement.execute(executionContext);
        }
    }

    public static class ElifClause implements AmirStatement{
        private AmirExpression condition;
        private List<AmirStatement> statementBlock;

        // Constructor
        public ElifClause(AmirExpression condition, List<AmirStatement> statementBlock) {
            this.condition = condition;
            this.statementBlock = statementBlock;
        }

        // Getters and setters
        public AmirExpression getCondition() {
            return condition;
        }

        public void setCondition(AmirExpression condition) {
            this.condition = condition;
        }

        public List<AmirStatement> getStatementBlock() {
            return statementBlock;
        }

        public void setStatementBlock(List<AmirStatement> statementBlock) {
            this.statementBlock = statementBlock;
        }

        @Override
        public String toSourceCode(int indentationLevel) {
            StringBuilder sb = new StringBuilder();
            String indentation = "    ".repeat(indentationLevel);

            sb.append(indentation).append("elif ").append(condition.toSourceCode(0)).append(":\n");
            for (AmirStatement statement : statementBlock) {
                sb.append(statement.toSourceCode(indentationLevel + 1));
            }
            return sb.toString();
        }

        @Override
        public void execute(ExecutionContext executionContext) {
            // Execution logic for ElifClause is handled by AmirIfStatement
        }

        private boolean evaluateCondition(AmirExpression condition, ExecutionContext executionContext) {
            Object evaluatedResult = condition.evaluate(executionContext);

            // Ensure the evaluated result is an Integer (memory address)
            if (!(evaluatedResult instanceof Integer)) {
                throw new IllegalArgumentException("Evaluation of expression did not return a valid memory address.");
            }

            Integer address = (Integer) evaluatedResult;
            Object result = executionContext.getHeap().retrieve(address);
            if (!(result instanceof Boolean)) {
                throw new IllegalArgumentException("Condition did not evaluate to a boolean value");
            }
            return (Boolean) result;
        }

        private void executeStatements(List<AmirStatement> statements, ExecutionContext executionContext) {
            for (AmirStatement statement : statements) {
                statement.execute(executionContext);
            }
        }
    }
    public static class ElseClause implements AmirStatement {
        private List<AmirStatement> statementBlock;

        // Constructor
        public ElseClause(List<AmirStatement> statementBlock) {
            this.statementBlock = statementBlock;
        }

        // Getters and setters
        public List<AmirStatement> getStatementBlock() {
            return statementBlock;
        }

        public void setStatementBlock(List<AmirStatement> statementBlock) {
            this.statementBlock = statementBlock;
        }

        @Override
        public String toSourceCode(int indentationLevel) {
            StringBuilder sb = new StringBuilder();

            // No need to append "else:\n" here as it's handled by AmirIfStatement
            for (AmirStatement statement : statementBlock) {
                sb.append(statement.toSourceCode(indentationLevel)); // Correctly indent statements within the else block
            }
            return sb.toString();
        }

        @Override
        public void execute(ExecutionContext executionContext) {
            // Execution logic for ElseClause is handled by AmirIfStatement
        }
        private void executeStatements(List<AmirStatement> statements, ExecutionContext executionContext) {
            for (AmirStatement statement : statements) {
                statement.execute(executionContext);
            }
        }
    }
}
