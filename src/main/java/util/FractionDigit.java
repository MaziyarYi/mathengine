package util;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class FractionDigit {

    private static FractionDigit instance;
    private int fractionDigit;

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
        return Double.parseDouble(nf.format(d));
    }

    public int getFractionDigit() {
        return fractionDigit;
    }

    public FractionDigit setFractionDigit(int fractionDigit) {
        this.fractionDigit = fractionDigit;
        return this;
    }
}
