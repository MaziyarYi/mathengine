package staticValue;

import model.Operand;
import model.Operator;

import java.util.ArrayList;
import java.util.List;

public class StaticOperation {

    private StaticOperation() {
    }

    public static final Operator ADD = new Operator("+", "add", Operator.ARITY_BINARY, Operator.PRECEDENCE_ADDITION, true) {
        @Override
        public Operand operate(Operand... operands) {
            return new Operand(operands[0].getNumber() + operands[1].getNumber());
        }
    };

    public static final Operator SUBTRACT = new Operator("-", "subtract", Operator.ARITY_BINARY, Operator.PRECEDENCE_ADDITION, true) {
        @Override
        public Operand operate(Operand... operands) {
            return new Operand(operands[0].getNumber() - operands[1].getNumber());
        }
    };

    public static final Operator MULTIPLY = new Operator("*", "multiply", Operator.ARITY_BINARY, Operator.PRECEDENCE_MULTIPLICATION, true) {
        @Override
        public Operand operate(Operand... operands) {
            return new Operand(operands[0].getNumber() * operands[1].getNumber());
        }
    };

    public static final Operator DIVIDE = new Operator("/", "divide", Operator.ARITY_BINARY, Operator.PRECEDENCE_MULTIPLICATION, true) {
        @Override
        public Operand operate(Operand... operands) {
            if (operands[1].getNumber() == 0)
                throw new ArithmeticException("Division By 0.");
            return new Operand(operands[0].getNumber() / operands[1].getNumber());
        }
    };

    public static final Operator MOD = new Operator("%", "mod", Operator.ARITY_BINARY, Operator.PRECEDENCE_MULTIPLICATION, true) {
        @Override
        public Operand operate(Operand... operands) {
            if (operands[1].getNumber() == 0)
                throw new ArithmeticException("Division (Mod) By 0.");

            double number = 1;
            number = operands[0].getNumber() % operands[1].getNumber();
            return new Operand(number);
        }
    };

    public static final Operator POWER = new Operator("^", "power", Operator.ARITY_BINARY, Operator.PRECEDENCE_POWER, false) {
        @Override
        public Operand operate(Operand... operands) {
            return new Operand(Math.pow(operands[0].getNumber(), operands[1].getNumber()));
        }
    };

    public static final Operator FACTORIAL = new Operator("!", "factorial", Operator.ARITY_UNARY, Operator.PRECEDENCE_FORCE, true) {
        @Override
        public Operand operate(Operand... operands) {
            Operand op = operands[0];
            if (op.getNumber() < 0)
                throw new IllegalArgumentException("Operand Of Factorial Must Be Greater Than 0.");

            double number = 1;
            for (int i = 1; i <= op.getNumber(); i++) {
                number *= i;
            }
            return new Operand(number);
        }
    };

    public static List<Operator> getClassicOperator() {
        List<Operator> classicOperators = new ArrayList<>();
        classicOperators.add(ADD);
        classicOperators.add(SUBTRACT);
        classicOperators.add(MULTIPLY);
        classicOperators.add(DIVIDE);
        classicOperators.add(MOD);
        return classicOperators;
    }

    public static List<Operator> getPremiumOperator() {
        List<Operator> premiumOperators = new ArrayList<>();
        premiumOperators.add(ADD);
        premiumOperators.add(SUBTRACT);
        premiumOperators.add(MULTIPLY);
        premiumOperators.add(DIVIDE);
        premiumOperators.add(MOD);
        premiumOperators.add(POWER);
        premiumOperators.add(FACTORIAL);
        return premiumOperators;
    }
}
