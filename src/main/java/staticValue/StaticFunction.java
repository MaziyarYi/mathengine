package staticValue;

import model.Function;
import model.Operand;

import java.util.ArrayList;
import java.util.List;

public class StaticFunction {

    private StaticFunction() {
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

    public static final Function COT = new Function("cot", 1) {
        @Override
        public Operand function(Operand... operands) {
            return new Operand(1 / Math.tan(Math.toRadians(operands[0].getNumber())));
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

    public static List<Function> getClassicFunction() {
        List<Function> classicFunctions = new ArrayList<>();
        classicFunctions.add(SIN);
        classicFunctions.add(COS);
        classicFunctions.add(TAN);
        classicFunctions.add(COT);
        return classicFunctions;
    }

    public static List<Function> getPremiumFunction() {
        List<Function> premiumFunctions = new ArrayList<>();
        premiumFunctions.add(SIN);
        premiumFunctions.add(COS);
        premiumFunctions.add(TAN);
        premiumFunctions.add(COT);
        premiumFunctions.add(CSC);
        premiumFunctions.add(SEC);
        return premiumFunctions;
    }

}
