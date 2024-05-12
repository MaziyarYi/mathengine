package Rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Min Digit Rule", description = "Using Float For Minimum Digit In Operations")
public class MinDigitRule extends MathRule<Class> {

    @Override
    @Condition
    public boolean when() {
        return false;
    }

    @Override
    @Action
    public void then() {
        result = Float.class;
    }

    @Override
    public boolean isExecuted() {
        return super.isExecuted();
    }

    @Override
    public Class getResult() {
        return super.getResult();
    }
}
