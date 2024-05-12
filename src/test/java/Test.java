import Rule.ClassicRule;
import Rule.MinDigitRule;

public class Test {
    public static void main(String[] args) {

        MathEngine mathEngine = new MathEngine();
        mathEngine.setMathRule(new ClassicRule()).setMathRule(new MinDigitRule());
        mathEngine.initMathEngineRules();

        System.out.println(mathEngine.evalOperation("2*7+2*2"));
        System.out.println(mathEngine.evalComparison("2>3"));

    }
}
