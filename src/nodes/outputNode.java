package nodes;

import lib.JsCompiler;

public class outputNode extends treeNode {
    private treeNode expression;

    public outputNode(treeNode expression) {
        this.expression = expression;
    }

    @Override
    public void execute() {
        System.out.println("Executing outputNode");
        double result = expression.evaluate();
        JsCompiler.printResult(result);
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("outputNode cannot be evaluated.");
    }
}
