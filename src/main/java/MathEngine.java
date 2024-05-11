import comparison.ComparisonBuilder;
import comparison.ComparisonFactory;
import defaultValue.ComparisonDefault;
import defaultValue.ConstantDefault;
import defaultValue.FunctionDefault;
import defaultValue.OperationDefault;
import model.Comparator;
import model.Constant;
import model.Function;
import model.Operator;
import operation.OperationBuilder;
import operation.OperationFactory;

import java.util.List;

public class MathEngine {

    private OperationFactory operationFactory;
    private ComparisonFactory comparisonFactory;

    public MathEngine() {
    }

    public MathEngine setDefaultStructure() {
        this.operationFactory = new OperationFactory(OperationDefault.getDefaultOperator(), ConstantDefault.getDefaultConstant(), FunctionDefault.getDefaultFunction());
        this.comparisonFactory = new ComparisonFactory(ComparisonDefault.getDefaultComparisonOperator());
        return this;
    }

    public MathEngine setStructure(List<Operator> operators, List<Constant> constants, List<Function> functions, List<Comparator> comparators) {
        this.operationFactory = new OperationFactory(operators, constants, functions);
        this.comparisonFactory = new ComparisonFactory(comparators);
        return this;
    }

    public Double evalOperation(String operation) {
        return new OperationBuilder(operation, operationFactory).parse().build().eval();
    }

    public Boolean evalComparison(String comparison) {
        return new ComparisonBuilder(comparison, comparisonFactory, operationFactory).parse().build().eval();
    }

}
