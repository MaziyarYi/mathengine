package Rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

import java.math.BigDecimal;

@Rule(name = "Min Digit Rule", description = "Using BigDecimal Maximum Digit In Operations")
public class MaxDigitRule extends MathRule<Class>{

    @Override
    @Condition
    public boolean when() {
        return false;
    }

    @Override
    @Action
    public void then() {
        result = BigDecimal.class;
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
