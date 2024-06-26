package model;

public abstract class Operator extends Section {

    private final String name;
    private final int precedence;
    private final int arity;
    private final boolean leftAssociative;

    public static int PRECEDENCE_ADDITION = 1;          // Addition, Subtraction
    public static int PRECEDENCE_MULTIPLICATION = 2;    // Multiplication, Division
    public static int PRECEDENCE_POWER = 3;             // Power
    public static int PRECEDENCE_FORCE = 15;            // First Priority

    public static int ARITY_UNARY = 1;
    public static int ARITY_BINARY = 2;

    public Operator(String element, String name, int arity, int precedence, boolean leftAssociative) {
        super(element);
        this.name = name;
        this.arity = arity;
        this.precedence = precedence;
        this.leftAssociative = leftAssociative;
    }

    public String getName() {
        return name;
    }

    public int getPrecedence() {
        return precedence;
    }

    public int getArity() {
        return arity;
    }

    public boolean isLeftAssociative() {
        return leftAssociative;
    }

    public static int getPrecedenceAddition() {
        return PRECEDENCE_ADDITION;
    }

    public static int getPrecedenceMultiplication() {
        return PRECEDENCE_MULTIPLICATION;
    }

    public static int getPrecedencePower() {
        return PRECEDENCE_POWER;
    }

    public static int getPrecedenceForce() {
        return PRECEDENCE_FORCE;
    }

    public static int getArityUnary() {
        return ARITY_UNARY;
    }

    public static int getArityBinary() {
        return ARITY_BINARY;
    }

    public Operand apply(Operand... operands) {
        if (operands.length != arity) {
            throw new IllegalArgumentException(name + " Operator Only Accept " + arity + " Operands As Parameter. "
                    + "(Parameter Passed: " + operands.length + ")");
        }
        return operate(operands);
    }

    public abstract Operand operate(Operand... operands);

    @Override
    public boolean equals(Object o) {
        return o instanceof Operator && this.getSection().equals(((Operator) o).getSection());
    }

}
