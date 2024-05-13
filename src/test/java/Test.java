import Rule.PremiumRule;

public class Test {
    public static void main(String[] args) {

        MathEngine mathEngine = new MathEngine();
        mathEngine.setMathRule(new PremiumRule(4));
        mathEngine.initMathEngineRules();

        System.out.println(mathEngine.evalOperation("0.02534*0.02587*2"));
        System.out.println(mathEngine.evalComparison("2>3"));

    }
}
