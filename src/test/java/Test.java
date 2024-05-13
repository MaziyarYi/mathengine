import Rule.PremiumRule;

public class Test {
    public static void main(String[] args) {

        MathEngine mathEngine = new MathEngine();
        mathEngine.setMathRule(new PremiumRule(4));
        mathEngine.initMathEngineRules();

        System.out.println(mathEngine.evalOperation("1.756542473/0.6545537*555.7856231/0.28731652"));
        System.out.println(mathEngine.evalComparison("2>3"));

    }
}
