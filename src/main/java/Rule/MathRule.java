package Rule;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "Math Rule", description = "Basic Rule Method")
public abstract class MathRule<T> {

    protected boolean executed;

    protected T result;

    @Condition
    public abstract boolean when();

    @Action
    public abstract void then();

    public boolean isExecuted(){
        return executed;
    }

    public T getResult(){
        return result;
    }

}
