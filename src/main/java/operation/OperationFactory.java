package operation;

import model.Constant;
import model.Function;
import model.Operator;

import java.util.List;

public class OperationFactory {

    private List<Operator> operators;
    private List<Constant> constants;
    private List<Function> functions;


    public OperationFactory(List<Operator> operators, List<Constant> constants, List<Function> functions) {
        this.operators = operators;
        this.constants = constants;
        this.functions = functions;
    }

    public void addOperator(Operator operator) {
        operators.add(operator);
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public OperationFactory setOperators(List<Operator> operators) {
        this.operators = operators;
        return this;
    }

    public void addConstant(Constant constant) {
        constants.add(constant);
    }

    public List<Constant> getConstants() {
        return constants;
    }

    public OperationFactory setConstants(List<Constant> constants) {
        this.constants = constants;
        return this;
    }

    public void addFunction(Function function) {
        functions.add(function);
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public OperationFactory setFunctions(List<Function> functions) {
        this.functions = functions;
        return this;
    }

}
