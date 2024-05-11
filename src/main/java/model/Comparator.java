package model;

import lombok.Getter;

@Getter
public abstract class Comparator extends Section {

    public final static int PRECEDENCE_TWO = 2;
    public final static int PRECEDENCE_ONE = 1;

    private int precedence;

    public Comparator(String section, int precedence) {
        super(section);
        this.precedence = precedence;
    }

    public abstract boolean compare(Operand o1, Operand o2);

}
