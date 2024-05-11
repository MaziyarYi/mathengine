package defaultValue;

import model.Function;
import model.Operand;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefault {

    private FunctionDefault() {
    }

    public static final Function SIN = new Function("sin", 1) {
        @Override
        public Operand function(Operand... operands) {
            return new Operand(Math.sin(Math.toRadians(operands[0].getNumber())));
        }
    };

    public static final Function COS = new Function("cos", 1) {
        @Override
        public Operand function(Operand... operands) {
            return new Operand(Math.cos(Math.toRadians(operands[0].getNumber())));
        }
    };

    public static final Function TAN = new Function("tan", 1) {
        @Override
        public Operand function(Operand... operands) {
            return new Operand(Math.tan(Math.toRadians(operands[0].getNumber())));
        }
    };

    public static final Function CSC = new Function("csc", 1) {
        @Override
        public Operand function(Operand... operands) {
            return new Operand(1 / Math.sin(Math.toRadians(operands[0].getNumber())));
        }
    };

    public static final Function SEC = new Function("sec", 1) {
        @Override
        public Operand function(Operand... operands) {
            return new Operand(1 / Math.cos(Math.toRadians(operands[0].getNumber())));
        }
    };

    public static final Function COT = new Function("cot", 1) {
        @Override
        public Operand function(Operand... operands) {
            return new Operand(1 / Math.tan(Math.toRadians(operands[0].getNumber())));
        }
    };

    public static List<Function> getDefaultFunction() {
        List<Function> functions = new ArrayList<>();
        functions.add(SIN);
        functions.add(COS);
        functions.add(TAN);
        functions.add(CSC);
        functions.add(SEC);
        functions.add(COT);
        return functions;
    }

}
