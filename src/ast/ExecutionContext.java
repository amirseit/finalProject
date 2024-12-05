package ast;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExecutionContext {
    private Stack stack = new Stack();
    private Heap heap = new Heap();
    private ClassStore classStore = new ClassStore();
    private Deque<Integer> objectInstanceStack = new ArrayDeque<>();
    public ExecutionContext() {}
    public Stack getStack() {
        return stack;
    }

    public Heap getHeap() {
        return heap;
    }

    public ClassStore getClassStore() {
        return classStore;
    }


    public Object retrieve(String variableName) {
        Integer address = stack.getAddress(variableName);
        if (address != null) {
            return heap.retrieve(address);
        }
        throw new RuntimeException("Variable '" + variableName + "' not found");
    }
    public void pushCurrentObjectInstance(int address) {
        objectInstanceStack.push(address);
    }

    public int popCurrentObjectInstance() {
        if (objectInstanceStack.isEmpty()) {
            throw new IllegalStateException("No current object instance available.");
        }
        return objectInstanceStack.pop();
    }

    public int getCurrentObjectInstance() {
        if (objectInstanceStack.isEmpty()) {
            throw new IllegalStateException("No current object instance available.");
        }
        return objectInstanceStack.peek();
    }
}
