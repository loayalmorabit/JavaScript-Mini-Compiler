package nodes;

public class whileNode extends treeNode {
    private treeNode condition;
    private treeNode body;

    public whileNode(treeNode condition, treeNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public void execute() {
        System.out.println("Executing whileNode");
        while (condition.evaluate() != 0) {
            body.execute();
        }
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("whileNode cannot be evaluated.");
    }
}
