package nodes;

public class termNode extends treeNode {

    @Override
    public double evaluate() {
        if (children.isEmpty()) {
            throw new IllegalStateException("No children in termNode to evaluate.");
        }

        double result = children.get(0).evaluate();

        for (int i = 1; i < children.size(); i += 2) {
            String operator = ((stringNode) children.get(i)).getValue();
            double value = children.get(i + 1).evaluate();
            if (operator.equals("*")) {
                result *= value;
            } else if (operator.equals("/")) {
                result /= value;
            } else {
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
            }
        }
        return result;
    }

    @Override
    public void execute() {
        System.out.println("Executing termNode");
        evaluate();
    }
}
