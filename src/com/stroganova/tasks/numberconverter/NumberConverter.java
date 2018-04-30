package com.stroganova.tasks.numberconverter;

import static java.lang.Math.round;

/**
 * Created by dp-ptcstd-15 on 4/18/2018.
 */
public class NumberConverter {

    static String toString(int intValue) {
        boolean isNegative = false;
        if (intValue < 0) {
            intValue = -intValue;
            isNegative = true;
        }
        String inverseResult = "";
        while (intValue != 0) {
            int number = intValue % 10;
            inverseResult += number;
            intValue = intValue / 10;
        }
        String result = "";
        char[] charArray = inverseResult.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            result += charArray[i];
        }
        return isNegative ? ("-" + result) : result;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    static int toInt(String stringValue) {
        // '-' = 45;
        //'0' = 48 '9' = 57
        char[] charArray = stringValue.toCharArray();
        int power = charArray.length - 1;
        int result = 0;
        int start = 0;
        boolean isNegative = false;
        if (charArray[0] == 45) {
            start = 1;
            power--;
            isNegative = true;
        }
        for (int i = start; i < charArray.length; i++) {
            int n = charArray[i] - '0';
            result = result + n * (int) Math.pow(10, power);
            power--;
        }
        return isNegative ? -result : result;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    static double toDouble(String stringValue) {
        // '.' = 46
        double result = 0D;
        char[] charArray = stringValue.toCharArray();
        int start = 0;
        boolean isNegative = false;
        if (charArray[0] == 45) {
            start = 1;
            isNegative = true;
        }
        double t = 1D;
        for (int i = charArray.length - 1; i >= start; i--) {
            if (charArray[i] != '.') {
                double n = charArray[i] - '0';
                result = result + n * t;
                t = t * 10;
            } else {
                t = 1D;
                result = result * Math.pow(10, (-(charArray.length - i - 1)));
            }
        }
        return isNegative ? -result : result;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    static String toString(double doubleValue) {
        boolean isNegative = false;
        if (doubleValue < 0) {
            doubleValue = -doubleValue;
            isNegative = true;
        }
        int positionOfPoint = 0;
        while (doubleValue % 1 != 0) {
            doubleValue = doubleValue * 10D;
            positionOfPoint++;
        }

        long val = (long) doubleValue;
        String result = toString(val);

        String beforePoint = "";
        String afterPoint = "";
        char point = 46;
        if (positionOfPoint != 0) {
            if (result.length() > positionOfPoint) {
                beforePoint = result.substring(0, result.length() - positionOfPoint);
                afterPoint = result.substring(result.length() - positionOfPoint, result.length());
                result = beforePoint + point + afterPoint;
            } else {
                beforePoint = "0";
                afterPoint = result;
                while (result.length() < positionOfPoint) {
                    afterPoint = "0" + afterPoint;
                    positionOfPoint--;
                }
                result = beforePoint + point + afterPoint;
            }
        }

        return isNegative ? ("-" + result) : result;
    }

    static String toString(long longValue) {
        boolean isNegative = false;
        if (longValue < 0) {
            longValue = -longValue;
            isNegative = true;
        }
        String inverseResult = "";
        while (longValue != 0) {
            long number = longValue % 10;
            inverseResult += number;
            longValue = longValue / 10;
        }
        String result = "";
        char[] charArray = inverseResult.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            result += charArray[i];
        }
        return isNegative ? ("-" + result) : result;
    }

    static double kahanSum(double[] array) {
        double sum = 0;
        double c = 0;
        for (double v : array) {
            double y = v - c;
            double t = sum + y;
            c = (t - sum) - y;
            sum = t;
        }
        return sum;
    }

}
