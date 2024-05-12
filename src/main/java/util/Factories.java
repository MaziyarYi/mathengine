package util;

import comparison.ComparisonFactory;
import operation.OperationFactory;

public class Factories {

    private static Factories instance;
    private OperationFactory operationFactory;
    private ComparisonFactory comparisonFactory;

    private Factories() {
    }

    public static Factories getInstance() {
        if (instance == null) {
            instance = new Factories();
        }
        return instance;
    }

    public OperationFactory getOperationFactory() {
        return operationFactory;
    }

    public void setOperationFactory(OperationFactory operationFactory) {
        this.operationFactory = operationFactory;
    }

    public ComparisonFactory getComparisonFactory() {
        return comparisonFactory;
    }

    public void setComparisonFactory(ComparisonFactory comparisonFactory) {
        this.comparisonFactory = comparisonFactory;
    }
}
