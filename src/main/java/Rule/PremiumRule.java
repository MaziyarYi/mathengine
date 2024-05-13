package Rule;

import comparison.ComparisonFactory;
import operation.OperationFactory;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import util.Factories;
import util.FractionDigit;

@Rule(name = "Premium Rule", description = "Using All Premium Operations")
public class PremiumRule {

    private boolean executed;
    private Integer fractionDigit;

    public PremiumRule(Integer fractionDigit) {
        this.fractionDigit = fractionDigit;
    }

    @Condition
    public boolean when() {
        return true;
    }

    @Action
    public void then() {
        FractionDigit.getInstance().setFractionDigit(fractionDigit);
        Factories.getInstance().setOperationFactory( new OperationFactory().initPremiumOperation());
        Factories.getInstance().setComparisonFactory(new ComparisonFactory().initPremiumComparison());
        executed = true;
    }

    public boolean isExecuted() {
        return executed;
    }
}

