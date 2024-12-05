package ast;

import java.util.HashMap;
import java.util.Map;
import java.util.Deque;
import java.util.ArrayDeque;

public class Stack {
    private Deque<Map<String, Integer>> scopeStack;

    public Stack() {
        this.scopeStack = new ArrayDeque<>();
        this.scopeStack.push(new HashMap<>()); // Start with the global scope
    }

    public void enterScope() {
        scopeStack.push(new HashMap<>());
    }

    public void exitScope() {
        if (scopeStack.size() > 1) {
            scopeStack.pop();
        } else {
            throw new IllegalStateException("Cannot exit global scope.");
        }
    }

    public void assign(String variableName, int address) {
        scopeStack.peek().put(variableName, address);
    }

    public Integer getAddress(String variableName) {
        for (Map<String, Integer> scope : scopeStack) {
            if (scope.containsKey(variableName)) {
                return scope.get(variableName);
            }
        }
        return null; // Or throw an exception if the variable is not found
    }

    public Map<String, Integer> getCurrentScopeVariables() {
        return new HashMap<>(scopeStack.peek());
    }
}
