package model;

public abstract class Comparator extends Section {

    public static final int PRECEDENCE_TWO = 2;
    public static final int PRECEDENCE_ONE = 1;

    private int precedence;

    public Comparator(String section, int precedence) {
        super(section);
        this.precedence = precedence;
    }

    public int getPrecedence() {
        return precedence;
    }

    public abstract boolean compare(Operand o1, Operand o2);

}
