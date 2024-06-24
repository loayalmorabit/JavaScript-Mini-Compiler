package nodes;

public class ifNode extends treeNode {
    private treeNode condition;
    private treeNode thenPart;
    private treeNode elsePart;

    public ifNode(treeNode condition, treeNode thenPart, treeNode elsePart) {
        this.condition = condition;
        this.thenPart = thenPart;
        this.elsePart = elsePart;
    }

    @Override
    public void execute() {
        System.out.println("Executing ifNode");
        double conditionResult = condition.evaluate();
        System.out.println("Condition result: " + conditionResult);
        if (conditionResult != 0) {
            System.out.println("Executing thenPart");
            thenPart.execute();
        } else if (elsePart != null) {
            System.out.println("Executing elsePart");
            elsePart.execute();
        }
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("ifNode cannot be evaluated.");
    }
}
