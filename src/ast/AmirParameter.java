package ast;

public class AmirParameter {
    private String name;

    public AmirParameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toSourceCode() {
        return name;
    }

    public void execute(ExecutionContext executionContext) {

    }
}
