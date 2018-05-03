package com.stroganova.numberconverter;

/**
 * Created by dp-ptcstd-15 on 4/18/2018.
 */
public class TestNumberConverter {
    public static void main(String[] args) {
        System.out.println("Start");
        String checkSI = NumberConverter.toString(-123);
        System.out.println(checkSI);
        int checkInt = NumberConverter.toInt("-321");
        System.out.println(checkInt);
        double checkD = NumberConverter.toDouble("-1123.1");
        System.out.println(checkD);
        System.out.println();
        String checkSD = NumberConverter.toString(-1.001D);
        System.out.println(checkSD);
        //1.001D -> "1.0009999999999998"
        //-0.0000000001D ->  "-0.0000000001" - ok
        //-0.00000000001D -> "-0.000000000009999999999999998"

        //-0.99999999999999D -> "-0.99999999999999" - ok
        //-0.9999999999999999D -> "-0.9999999999999998"
        //-0.99999999999999999D -> "-1"











    }
}
