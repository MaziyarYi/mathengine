public class Test {
    public static void main(String[] args) {
        System.out.println(new MathEngine().setDefaultStructure().evalOperation("2*5"));
        System.out.println(new MathEngine().setDefaultStructure().evalComparison("2>5"));
    }
}
