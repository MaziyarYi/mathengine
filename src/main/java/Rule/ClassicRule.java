package Rule;

import comparison.ComparisonFactory;
import operation.OperationFactory;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import util.Factories;
import util.FractionDigit;

@Rule(name = "Classic Rule", description = "Using All Classic Operations")
public class ClassicRule {

    private boolean executed;
    private Integer fractionDigit;

    public ClassicRule(Integer fractionDigit) {
        this.fractionDigit = fractionDigit;
    }

    @Condition
    public boolean when() {
        return true;
    }

    @Action
    public void then() {
        FractionDigit.getInstance().setFractionDigit(fractionDigit);
        Factories.getInstance().setOperationFactory( new OperationFactory().initClassicOperation());
        Factories.getInstance().setComparisonFactory(new ComparisonFactory().initClassicComparison());
        executed = true;
    }

    public boolean isExecuted() {
        return executed;
    }

}
