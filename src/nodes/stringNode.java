package nodes;

public class stringNode extends treeNode {
    private String value;

    public stringNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("stringNode cannot be evaluated.");
    }

    @Override
    public void execute() {
        // Execution is not directly applicable to stringNode.
    }
}
