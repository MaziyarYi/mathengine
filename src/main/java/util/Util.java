package util;

import java.math.BigInteger;

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
