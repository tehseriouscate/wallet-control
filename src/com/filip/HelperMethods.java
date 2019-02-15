package com.filip;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class HelperMethods {

    //method for rounding the balance up to 2 decimal points
    public static BigDecimal round(double value) {

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd;
    }

    // method for converting the double value to BigInteger value
    public static BigInteger convert(double value) {

        BigDecimal bd = new BigDecimal(100);
        return round(value).multiply(bd).toBigInteger();
    }


}
