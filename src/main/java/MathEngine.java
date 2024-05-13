import Rule.ClassicRule;
import Rule.FractionDigitRule;
import Rule.MathRule;
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

    private List<MathRule> rules = new ArrayList<>();

    public MathEngine() {
    }

    public MathEngine setMathRules(List<MathRule> rules) {
        if (Objects.isNull(rules)) throw new RuntimeException("Must Define Rule");
        this.rules = rules;
        return this;
    }

    public MathEngine setMathRule(MathRule rule) {
        if (Objects.isNull(rule)) throw new RuntimeException("Must Define Rule");
        this.rules.add(rule);
        return this;
    }

    public void initMathEngineRules() {
        if (Objects.isNull(rules)) throw new RuntimeException("No Rules Or Facts Are Defined");
        Rules rul = new Rules();
        if ((this.rules.stream().anyMatch(r -> r instanceof ClassicRule) || this.rules.stream().anyMatch(r -> r instanceof PremiumRule)) && this.rules.stream().anyMatch(r -> r instanceof FractionDigitRule)) {
            for (MathRule rule : this.rules) {
                rul.register(rule);
            }
            new DefaultRulesEngine().fire(rul, new Facts());
        } else {
            throw new RuntimeException("Must Define A Premium Rule Or Classic Rule And A Fraction Digit Rule");
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
