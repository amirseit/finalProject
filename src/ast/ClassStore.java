package ast;

import java.util.HashMap;
import java.util.Map;

public class ClassStore {
    private Map<String, AmirClassDefinition> classes = new HashMap<>();

    public void define(String className, AmirClassDefinition classDeclaration) {
        classes.put(className, classDeclaration);
    }

    public AmirClassDefinition retrieve(String className) {
        return classes.get(className);
    }

    public boolean isDefined(String className) {
        return classes.containsKey(className);
    }
    public int size() {
        return classes.size();
    }
}
