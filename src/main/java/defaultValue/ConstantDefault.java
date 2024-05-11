package defaultValue;

import model.Constant;

import java.util.ArrayList;
import java.util.List;

public class ConstantDefault {

    private ConstantDefault() {
    }

    public static final Constant PI = new Constant(Math.PI, "pi", "π");
    public static final Constant E = new Constant(Math.E, "e");
    public static final Constant GOLDEN_RATIO = new Constant(1.6180339887498948482, "φ");

    public static List<Constant> getDefaultConstant() {
        List<Constant> constants = new ArrayList<>();
        constants.add(PI);
        constants.add(E);
        constants.add(GOLDEN_RATIO);
        return constants;
    }

}
