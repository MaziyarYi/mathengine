package Rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;
import util.FractionDigit;

@Rule(name = "Fraction Digit Rule", description = "Using Specific Fraction Digit In Operations")
public class FractionDigitRule extends MathRule<Integer> {

    public FractionDigitRule(Integer digit) {
        this.result = digit;
    }

    @Override
    @Condition
    public boolean when() {
        return false;
    }

    @Override
    @Action
    public void then() {
        FractionDigit.getInstance().setFractionDigit(result);
        executed = true;
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
