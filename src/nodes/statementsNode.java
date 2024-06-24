package nodes;

import java.util.ArrayList;
import java.util.List;

public class statementsNode extends treeNode {
    private List<treeNode> children = new ArrayList<>();

    public void addChild(treeNode child) {
        children.add(child);
    }

    @Override
    public void execute() {
        for (treeNode child : children) {
        	System.out.println("Executing child node in statementsNode");
            child.execute();
        }
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("statementsNode cannot be evaluated.");
    }
}
