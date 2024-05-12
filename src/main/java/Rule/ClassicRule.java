package Rule;

import comparison.ComparisonFactory;
import operation.OperationFactory;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import util.Factories;

@Rule(name = "Classic Rule", description = "Using All Classic Operations")
public class ClassicRule extends MathRule {

    @Override
    @Condition
    public boolean when() {
        return true;
    }

    @Override
    @Action
    public void then() {
        Factories.getInstance().setOperationFactory( new OperationFactory().initClassicOperation());
        Factories.getInstance().setComparisonFactory(new ComparisonFactory().initClassicComparison());
        executed = true;
    }

    @Override
    public boolean isExecuted() {
        return super.isExecuted();
    }

}
