package operation;

import model.Constant;
import model.Function;
import model.Operator;
import staticValue.StaticConstant;
import staticValue.StaticFunction;
import staticValue.StaticOperation;

import java.util.List;

public class OperationFactory {

    private List<Operator> operators;
    private List<Constant> constants;
    private List<Function> functions;


    public OperationFactory() {
    }

    public OperationFactory initClassicOperation() {
        this.operators = StaticOperation.getClassicOperator();
        this.constants = StaticConstant.getClassicConstant();
        this.functions = StaticFunction.getClassicFunction();
        return this;
    }

    public OperationFactory initPremiumOperation() {
        this.operators = StaticOperation.getPremiumOperator();
        this.constants = StaticConstant.getPremiumConstant();
        this.functions = StaticFunction.getPremiumFunction();
        return this;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public List<Constant> getConstants() {
        return constants;
    }

    public List<Function> getFunctions() {
        return functions;
    }

}
