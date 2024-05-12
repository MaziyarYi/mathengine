package Rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Normal Digit Rule", description = "Using Double For Normal Digit In Operations")
public class NormalDigitRule extends MathRule<Class>{

    @Override
    @Condition
    public boolean when() {
        return false;
    }

    @Override
    @Action
    public void then() {
        result = Double.class;
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
