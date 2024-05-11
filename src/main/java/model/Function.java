package model;

public abstract class Function extends Section {

    private final int parameters;

    public Function(String element, int parameters) {
        super(element);
        this.parameters = parameters;
    }

    public int getParameters() {
        return parameters;
    }

    public Operand apply(Operand... operands) {
        if (operands.length != parameters) {
            throw new IllegalArgumentException(getSection() + " Function Only Accept " + parameters + " Operands As Parameter. "
                    + "(Parameter Passed: " + operands.length + ")");
        }
        return function(operands);
    }

    public abstract Operand function(Operand... operands);

    @Override
    public boolean equals(Object o) {
        return o instanceof Function && this.getSection().equals(((Function) o).getSection()) && this.getParameters() == ((Function) o).getParameters();
    }
}
