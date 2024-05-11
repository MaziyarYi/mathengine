package comparison;

import model.Comparator;
import operation.Operation;
import operation.OperationBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComparisonBuilder {

    private String comparison;

    private Comparator comparator;

    private Operation operation_left;
    private Operation operation_right;

    private HashMap<String, Comparator> operators;
    private ComparisonDefaultFactory defaultFactory = new ComparisonDefaultFactory();

    public ComparisonBuilder(String comparison) {
        this.comparison = comparison;
        this.operators = new HashMap<>();
        addDefaultPack();
    }

    public ComparisonBuilder(Operation operation_left, String comparison, Operation operation_right) {
        this.comparison = comparison;
        this.operation_left = operation_left;
        this.operation_right = operation_right;
        this.operators = new HashMap<>();
        addDefaultPack();
        this.comparator = operators.get(comparison);
    }

    private void addDefaultPack() {
        addComparisonOperator(defaultFactory.getDefaultComparisonOperator().toArray(new Comparator[defaultFactory.getDefaultComparisonOperator().size()]));
    }

    public ComparisonBuilder addComparisonOperator(Comparator... comparators) {
        for (Comparator com : comparators) {
            operators.put(com.getSection(), com);
        }
        return this;
    }

    public Comparison build() {
        return new Comparison(operation_right, comparator, operation_left);
    }

    private String buildRegex() {
        StringBuilder comparisons = new StringBuilder("(");
        int counter = 0;

        List<Comparator> comparators = new ArrayList<>(operators.values());
        Collections.sort(comparators, (o1, o2) -> o1.getPrecedence() > o2.getPrecedence() ? -1 : o1.getPrecedence() == o2.getPrecedence() ? 0 : 1);


        for (Comparator com : comparators) {
            comparisons.append(com.getSection()).append(counter == operators.size() - 1 ? "" : "|");
            counter++;
        }
        return comparisons.append(")").toString();
    }

    public ComparisonBuilder parse() {
        if ((operation_left == null && operation_right != null) || (operation_left != null && operation_right == null)) {
            throw new NullPointerException("One Of The Operation Must Be Initialized.");
        } else if (operation_left == null) {
            Matcher matcher = Pattern.compile(buildRegex()).matcher(comparison);

            if (matcher.find()) {

                comparator = operators.get(matcher.group());
                String[] operations = comparison.split(buildRegex(), 2);

                if (operations.length != 2) {
                    throw new IllegalArgumentException("Comparisons Need To Have Two Operations. Found: " + operations.length);
                } else {
                    operation_left = new OperationBuilder(operations[0]).parse().build();
                    operation_right = new OperationBuilder(operations[1]).parse().build();
                }
            } else {
                throw new IllegalArgumentException("Cannot Find A Comparison Operator In The Expression.");
            }
        }
        return this;
    }

}
