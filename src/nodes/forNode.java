package nodes;

public class forNode extends treeNode {
    private treeNode init;
    private treeNode condition;
    private treeNode update;
    private treeNode body;

    public forNode(treeNode init, treeNode condition, treeNode update, treeNode body) {
        this.init = init;
        this.condition = condition;
        this.update = update;
        this.body = body;
    }

    @Override
    public void execute() {
        System.out.println("Executing forNode");
        for (init.execute(); condition.evaluate() != 0; update.execute()) {
            body.execute();
        }
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("forNode cannot be evaluated.");
    }
}
