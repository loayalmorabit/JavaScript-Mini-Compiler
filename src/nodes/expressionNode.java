package nodes;

public class expressionNode extends treeNode {

    @Override
    public double evaluate() {
        if (children.isEmpty()) {
            throw new IllegalStateException("No children in expressionNode to evaluate.");
        }

        double result = children.get(0).evaluate();
        System.out.println("Evaluating expressionNode: initial value = " + result);

        for (int i = 1; i < children.size(); i += 2) {
            String operator = ((stringNode) children.get(i)).getValue();
            double value = children.get(i + 1).evaluate();
            System.out.println("Evaluating expressionNode: applying operator " + operator + " with value " + value);
            switch (operator) {
                case "+":
                    result += value;
                    break;
                case "-":
                    result -= value;
                    break;
                case "*":
                    result *= value;
                    break;
                case "/":
                    if (value == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result /= value;
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported operator: " + operator);
            }
            System.out.println("Evaluating expressionNode: intermediate result = " + result);
        }
        System.out.println("Evaluating expressionNode: final result = " + result);
        return result;
    }

    @Override
    public void execute() {
        System.out.println("Executing expressionNode");
        evaluate();
    }
}
