package comparison;

import model.Comparator;
import staticValue.StaticComparison;

import java.util.List;

public class ComparisonFactory {

    private List<Comparator> comparators;

    public ComparisonFactory() {
    }

    public ComparisonFactory initClassicComparison(){
        this.comparators = StaticComparison.getClassicComparison();
        return this;
    }

    public ComparisonFactory initPremiumComparison(){
        this.comparators = StaticComparison.getPremiumComparison();
        return this;
    }

    public List<Comparator> getComparators() {
        return comparators;
    }

}
