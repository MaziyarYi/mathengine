package comparison;

import model.Operand;
import operation.Operation;

public class Comparison {

    private String comparison;

    private Comparator comparator;
    private Operation operation_right;
    private Operation operation_left;

    public Comparison(Operation right, Comparator comparator, Operation left) {
        this.operation_right = right;
        this.comparator = comparator;
        this.operation_left = left;
        this.comparison = operation_right.getOperation() + comparator.getSection() + operation_left.getOperation();
    }

    public boolean eval() {
        if (comparator == null) throw new IllegalArgumentException("Unknown Comparison Operator.");
        return comparator.compare(new Operand(operation_right.eval()), new Operand(operation_left.eval()));
    }

    public String getComparison() {
        return this.comparison;
    }
}
