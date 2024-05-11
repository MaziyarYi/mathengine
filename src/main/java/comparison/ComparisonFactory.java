package comparison;

import model.Comparator;

import java.util.List;

public class ComparisonFactory {

    private List<Comparator> comparators;

    public ComparisonFactory(List<Comparator> comparators) {
        this.comparators = comparators;
    }

    public void addComparator(Comparator comparator) {
        this.comparators.add(comparator);
    }

    public List<Comparator> getComparators() {
        return comparators;
    }

    public ComparisonFactory setComparators(List<Comparator> comparators) {
        this.comparators = comparators;
        return this;
    }

}
