package Rule;

import comparison.ComparisonFactory;
import operation.OperationFactory;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import util.Factories;

@Rule(name = "Premium Rule", description = "Using All Premium Operations")
public class PremiumRule extends MathRule {

    @Override
    @Condition
    public boolean when() {
        return true;
    }

    @Override
    @Action
    public void then() {
        Factories.getInstance().setOperationFactory( new OperationFactory().initPremiumOperation());
        Factories.getInstance().setComparisonFactory(new ComparisonFactory().initPremiumComparison());
        executed = true;
    }

    @Override
    public boolean isExecuted() {
        return super.isExecuted();
    }
}

