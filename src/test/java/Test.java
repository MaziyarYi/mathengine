import comparison.ComparisonBuilder;
import operation.OperationBuilder;

public class Test {
    public static void main(String[] args) {
        System.out.println(new OperationBuilder("3.3 * 10").parse().build().eval());

        System.out.println(new ComparisonBuilder("2>3").parse().build().eval());
    }
}
