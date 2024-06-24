package nodes;

import lib.JsCompiler;

public class factorNode extends treeNode {
    private String value;
    private boolean isNumber;
    private treeNode expr;

    public factorNode(String value, boolean isNumber) {
        this.value = value;
        this.isNumber = isNumber;
        this.expr = null;
    }

    public factorNode(treeNode expr) {
        this.value = null;
        this.isNumber = false;
        this.expr = expr;
    }

    @Override
    public double evaluate() {
        if (isNumber) {
            return Double.parseDouble(value);
        } else if (expr != null) {
            return expr.evaluate();
        } else {
            return JsCompiler.getVariableValue(value);
        }
    }

    @Override
    public void execute() {
    	 System.out.println("Executing factorNode");
    	 evaluate();
    }
}




