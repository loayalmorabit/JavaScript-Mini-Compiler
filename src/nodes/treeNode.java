package nodes;

import java.util.ArrayList;
import java.util.List;

public abstract class treeNode {
    protected List<treeNode> children = new ArrayList<>();

    public void addChild(treeNode child) {
        children.add(child);
    }

    public abstract void execute();

    public double evaluate() {
        throw new UnsupportedOperationException("This node cannot be evaluated.");
    }
}
