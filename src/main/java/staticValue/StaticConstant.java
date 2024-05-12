package staticValue;

import model.Constant;

import java.util.ArrayList;
import java.util.List;

public class StaticConstant {

    private StaticConstant() {
    }

    public static final Constant PI = new Constant(Math.PI, "pi", "π");
    public static final Constant E = new Constant(Math.E, "e");
    public static final Constant GOLDEN_RATIO = new Constant(1.6180339887498948482, "φ");

    public static List<Constant> getClassicConstant() {
        List<Constant> classicConstants = new ArrayList<>();
        classicConstants.add(PI);
        classicConstants.add(E);
        return classicConstants;
    }

    public static List<Constant> getPremiumConstant() {
        List<Constant> premiumConstants = new ArrayList<>();
        premiumConstants.add(PI);
        premiumConstants.add(E);
        premiumConstants.add(GOLDEN_RATIO);
        return premiumConstants;
    }

}
