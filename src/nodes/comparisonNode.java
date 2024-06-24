package nodes;

public class comparisonNode extends expressionNode {

    @Override
    public double evaluate() {
        if (children.isEmpty()) {
            throw new IllegalStateException("No children in comparisonNode to evaluate.");
        }

        double result = children.get(0).evaluate();
        System.out.println("Evaluating comparisonNode: initial value = " + result);

        for (int i = 1; i < children.size(); i += 2) {
            String operator = ((stringNode) children.get(i)).getValue();
            double value = children.get(i + 1).evaluate();
            System.out.println("Evaluating comparisonNode: applying operator " + operator + " with value " + value);
            switch (operator) {
                case ">":
                    result = (result > value) ? 1 : 0;
                    break;
                case "<":
                    result = (result < value) ? 1 : 0;
                    break;
                case ">=":
                    result = (result >= value) ? 1 : 0;
                    break;
                case "<=":
                    result = (result <= value) ? 1 : 0;
                    break;
                case "==":
                    result = (result == value) ? 1 : 0;
                    break;
                case "!=":
                    result = (result != value) ? 1 : 0;
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported operator: " + operator);
            }
            System.out.println("Evaluating comparisonNode: intermediate result = " + result);
        }
        System.out.println("Evaluating comparisonNode: final result = " + result);
        return result;
    }

    @Override
    public void execute() {
        System.out.println("Executing comparisonNode");
        evaluate();
    }
}
