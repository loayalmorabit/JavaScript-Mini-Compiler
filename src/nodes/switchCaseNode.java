package nodes;

import java.util.List;

public class switchCaseNode extends treeNode {
    private String value;
    private boolean isDefault;
    private List<treeNode> body;

    public switchCaseNode(String value, boolean isDefault, List<treeNode> body) {
        this.value = value;
        this.isDefault = isDefault;
        this.body = body;
    }

    public boolean matches(double switchValue) {
        return !isDefault && Double.parseDouble(value) == switchValue;
    }

    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public void execute() {
        System.out.println("Executing switchCaseNode");
        try {
            for (treeNode child : body) {
                child.execute();
            }
        } catch (breakNode.BreakException e) {
            // Break statement encountered, exit case execution
        }
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("switchCaseNode cannot be evaluated.");
    }
}
