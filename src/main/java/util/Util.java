package util;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Util {

    public static boolean isNumber(String number){
        try {
            Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int getGCD(int num, int num2) {
        return BigInteger.valueOf(num).gcd(BigInteger.valueOf(num2)).intValue();
    }

}
