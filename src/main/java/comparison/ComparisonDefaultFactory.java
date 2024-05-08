package comparison;

import model.Operand;

import java.util.ArrayList;
import java.util.List;

public class ComparisonDefaultFactory {

    public static final Comparator EQUAL = new Comparator("=", Comparator.PRECEDENCE_ONE) {
        @Override
        public boolean compare(Operand o1, Operand o2) {
            return o1.equals(o2);
        }
    };

    public static final Comparator GREATER = new Comparator(">", Comparator.PRECEDENCE_ONE) {
        @Override
        public boolean compare(Operand o1, Operand o2) {
            return o1.getNumber() > o2.getNumber();
        }
    };

    public static final Comparator GREATER_EQ = new Comparator(">=", Comparator.PRECEDENCE_TWO) {
        @Override
        public boolean compare(Operand o1, Operand o2) {
            return o1.getNumber() >= o2.getNumber();
        }
    };

    public static final Comparator LESS = new Comparator("<", Comparator.PRECEDENCE_ONE) {
        @Override
        public boolean compare(Operand o1, Operand o2) {
            return o1.getNumber() < o2.getNumber();
        }
    };

    public static final Comparator LESS_EQ = new Comparator("<=", Comparator.PRECEDENCE_TWO) {
        @Override
        public boolean compare(Operand o1, Operand o2) {
            return o1.getNumber() <= o2.getNumber();
        }
    };

    public static final Comparator UNEQUAL = new Comparator("!=", Comparator.PRECEDENCE_TWO) {
        @Override
        public boolean compare(Operand o1, Operand o2) {
            return o1.getNumber() != o2.getNumber();
        }
    };

    public List<Comparator> getDefaultComparisonOperator() {
        List<Comparator> comOperators = new ArrayList<>();
        comOperators.add(EQUAL);
        comOperators.add(GREATER);
        comOperators.add(GREATER_EQ);
        comOperators.add(LESS);
        comOperators.add(LESS_EQ);
        comOperators.add(UNEQUAL);
        return comOperators;
    }

}
