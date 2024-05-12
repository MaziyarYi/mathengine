package staticValue;

import model.Comparator;
import model.Operand;

import java.util.ArrayList;
import java.util.List;

public class StaticComparison {

    private StaticComparison() {
    }

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

    public static final Comparator AND = new Comparator("&&", Comparator.PRECEDENCE_TWO) {
        @Override
        public boolean compare(Operand o1, Operand o2) {
            return false; //TODO
        }
    };

    public static final Comparator OR = new Comparator("||", Comparator.PRECEDENCE_TWO) {
        @Override
        public boolean compare(Operand o1, Operand o2) {
            return false; //TODO
        }
    };

    public static List<Comparator> getClassicComparison(){
        List<Comparator> classicComparison = new ArrayList<>();
        classicComparison.add(EQUAL);
        classicComparison.add(GREATER);
        classicComparison.add(GREATER_EQ);
        classicComparison.add(LESS);
        classicComparison.add(LESS_EQ);
        return classicComparison;
    }

    public static List<Comparator> getPremiumComparison () {
        List<Comparator> premiumComparison = new ArrayList<>();
        premiumComparison.add(EQUAL);
        premiumComparison.add(GREATER);
        premiumComparison.add(GREATER_EQ);
        premiumComparison.add(LESS);
        premiumComparison.add(LESS_EQ);
        premiumComparison.add(UNEQUAL);
        premiumComparison.add(AND);
        premiumComparison.add(OR);
        return premiumComparison;
    }

}
