package nodes;

import java.util.List;

public class switchNode extends treeNode {
    private treeNode expr;
    private List<switchCaseNode> caseList;

    public switchNode(treeNode expr, List<switchCaseNode> caseList) {
        this.expr = expr;
        this.caseList = caseList;
    }

    @Override
    public void execute() {
        System.out.println("Executing switchNode");
        double switchValue = expr.evaluate();
        boolean caseExecuted = false;

        for (switchCaseNode sc : caseList) {
            if (sc.isDefault() || (!caseExecuted && sc.matches(switchValue))) {
                try {
                    sc.execute();
                } catch (breakNode.BreakException e) {
                    break;
                }
                caseExecuted = true;
                if (!sc.isDefault()) break; // Execute only the matching case
            }
        }
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("switchNode cannot be evaluated.");
    }
}
