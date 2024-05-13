import Rule.ClassicRule;
import Rule.PremiumRule;
import comparison.ComparisonBuilder;
import operation.OperationBuilder;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;
import util.Factories;
import util.FractionDigit;

import java.util.*;

public class MathEngine {

    private Object rule;

    public MathEngine() {
    }

    public MathEngine setMathRule(Object rule) {
        if (Objects.isNull(rule)) throw new UnsupportedOperationException("Must Define Rule");
        this.rule = rule;
        return this;
    }

    public void initMathEngineRules() {
        if (Objects.isNull(rule))
            throw new UnsupportedOperationException("No Rule Is Defined");

        if (rule instanceof ClassicRule || rule instanceof PremiumRule) {
            Rules rul = new Rules();
            rul.register(rule);
            new DefaultRulesEngine().fire(rul, new Facts());
        } else {
            throw new UnsupportedOperationException("Define Unexpected Rule");
        }
    }

    public Double evalOperation(String operation) {
        if (Objects.isNull(Factories.getInstance().getOperationFactory()) || Objects.isNull(Factories.getInstance().getComparisonFactory()) || Objects.isNull(FractionDigit.getInstance().getFractionDigit()))
            initMathEngineRules();
        return new OperationBuilder(operation).parse().build().eval();
    }

    public Boolean evalComparison(String comparison) {
        if (Objects.isNull(Factories.getInstance().getOperationFactory()) || Objects.isNull(Factories.getInstance().getComparisonFactory()) || Objects.isNull(FractionDigit.getInstance().getFractionDigit()))
            initMathEngineRules();
        return new ComparisonBuilder(comparison).parse().build().eval();
    }

}
