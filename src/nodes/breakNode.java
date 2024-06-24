package nodes;

public class breakNode extends treeNode {

    @Override
    public void execute() {
        throw new BreakException();
    }

    @Override
    public double evaluate() {
        throw new UnsupportedOperationException("breakNode cannot be evaluated.");
    }

    // Inner class for the break exception
    public static class BreakException extends RuntimeException {
    }
}
