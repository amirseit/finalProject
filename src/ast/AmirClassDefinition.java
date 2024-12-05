package ast;

import java.util.List;

public class AmirClassDefinition implements AmirDefinition {
    private String name;
    private List<AmirDeclareAssign> fields;
    private List<AmirConstructorDefinition> constructors;
    private List<AmirMethodDefinition> methods;

    // Constructor to initialize class attributes
    public AmirClassDefinition(String name, List<AmirDeclareAssign> fields, List<AmirConstructorDefinition> constructors, List<AmirMethodDefinition> methods) {
        this.name = name;
        this.fields = fields;
        this.constructors = constructors;
        this.methods = methods;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AmirDeclareAssign> getFields() {
        return fields;
    }

    public void setFields(List<AmirDeclareAssign> fields) {
        this.fields = fields;
    }

    public List<AmirConstructorDefinition> getConstructors() {
        return constructors;
    }

    public void setConstructors(List<AmirConstructorDefinition> constructors) {
        this.constructors = constructors;
    }

    public List<AmirMethodDefinition> getMethods() {
        return methods;
    }

    public void setMethods(List<AmirMethodDefinition> methods) {
        this.methods = methods;
    }

    @Override
    public String toSourceCode(int indentationLevel) {
        StringBuilder sb = new StringBuilder();
        String indentation = "    ".repeat(indentationLevel);

        sb.append(indentation).append("class ").append(name).append(":\n");

        // Check if there are no fields, constructors, or methods
        if (fields.isEmpty() && constructors.isEmpty() && methods.isEmpty()) {
            throw new IllegalStateException("Error: Class '" + name + "' cannot be empty. A class must have at least one field, constructor, or method.");
        }

        int innerIndentationLevel = indentationLevel + 1;
        for (AmirDeclareAssign field : fields) {
            sb.append(field.toSourceCode(innerIndentationLevel)).append("\n");
        }

        for (AmirConstructorDefinition constructor : constructors) {
            sb.append(constructor.toSourceCode(innerIndentationLevel)).append("\n");
        }
        for (AmirMethodDefinition method : methods) {
            sb.append(method.toSourceCode(innerIndentationLevel)).append("\n");
        }

        return sb.toString().trim() + "\n";
    }



    @Override
    public void define(ExecutionContext executionContext) {
        System.out.println("Definition method for AmirClassDefinition start");
        // Define class in the execution context
        executionContext.getClassStore().define(name, this);
        System.out.println("Definition method for AmirClassDefinition finish");
    }
}

