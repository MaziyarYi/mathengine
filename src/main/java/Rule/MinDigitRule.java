package Rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Min Digit Rule", description = "Using Minimum Digit In Operations")
public class MinDigitRule extends MathRule<Integer> {

    @Override
    @Condition
    public boolean when() {
        return false;
    }

    @Override
    @Action
    public void then() {
        result = 3;
    }

    @Override
    public boolean isExecuted() {
        return super.isExecuted();
    }

    @Override
    public Integer getResult() {
        return super.getResult();
    }
}
