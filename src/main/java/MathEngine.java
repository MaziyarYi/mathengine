import Rule.MathRule;
import comparison.ComparisonBuilder;
import operation.OperationBuilder;
import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.core.DefaultRulesEngine;
import util.Factories;

import java.util.*;

public class MathEngine {

    private List<MathRule> rules = new ArrayList<>();

    public MathEngine() {
    }

    public MathEngine setMathRule(List<MathRule> rules){
        if (Objects.isNull(rules))
            throw new RuntimeException("Must Define Rule");
        this.rules = rules;
        return this;
    }

    public MathEngine setMathRule(MathRule rule){
        if (Objects.isNull(rule))
            throw new RuntimeException("Must Define Rule");
        this.rules.add(rule);
        return this;
    }

    public void initMathEngineRules(){
        if (Objects.isNull(rules))
            throw new RuntimeException("No Rules Are Defined");
        Rules rules = new Rules();
        for (MathRule rule: this.rules) {
            rules.register(rule);
        }
        new DefaultRulesEngine().fire(rules, new Facts());
    }

    public Double evalOperation(String operation) {
        if(Objects.isNull(Factories.getInstance().getOperationFactory()) || Objects.isNull(Factories.getInstance().getComparisonFactory()))
            initMathEngineRules();
        return new OperationBuilder(operation, Factories.getInstance().getOperationFactory()).parse().build().eval();
    }

    public Boolean evalComparison(String comparison) {
        if(Objects.isNull(Factories.getInstance().getOperationFactory()) || Objects.isNull(Factories.getInstance().getComparisonFactory()))
            initMathEngineRules();
        return new ComparisonBuilder(comparison, Factories.getInstance().getComparisonFactory(), Factories.getInstance().getOperationFactory()).parse().build().eval();
    }

}
