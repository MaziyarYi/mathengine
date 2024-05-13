package util;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class FractionDigit {

    private static FractionDigit instance;
    private Integer fractionDigit;

    private FractionDigit() {
    }

    public static FractionDigit getInstance(){
        if (instance == null) {
            instance = new FractionDigit();
        }
        return instance;
    }

    public double truncate(Double d) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(fractionDigit);
        nf.setRoundingMode(RoundingMode.DOWN);
        nf.setGroupingUsed(false);
        return Double.parseDouble(nf.format(d));
    }

    public Integer getFractionDigit() {
        return fractionDigit;
    }

    public void setFractionDigit(Integer fractionDigit) {
        this.fractionDigit = fractionDigit;
    }
}
