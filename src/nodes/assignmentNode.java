package nodes;

import lib.JsCompiler;

public class assignmentNode extends treeNode {
    private String variableName;
    private treeNode expression;

    public assignmentNode(String variableName, treeNode expression) {
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public void execute() {
    	System.out.println("Executing assignmentNode: " + variableName);
        double value = expression.evaluate();
        JsCompiler.assignVariable(variableName, value);
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("assignmentNode cannot be evaluated.");
    }
}