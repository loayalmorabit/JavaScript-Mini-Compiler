package nodes;

public class doWhileNode extends treeNode {
    private treeNode body;
    private treeNode condition;

    public doWhileNode(treeNode body, treeNode condition) {
        this.body = body;
        this.condition = condition;
    }

    @Override
    public void execute() {
        System.out.println("Executing doWhileNode");
        do {
            body.execute();
        } while (condition.evaluate() != 0);
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("doWhileNode cannot be evaluated.");
    }
}
