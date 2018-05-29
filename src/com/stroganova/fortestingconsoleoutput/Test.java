package com.stroganova.fortestingconsoleoutput;


import java.io.PrintStream;

public class Test {
    public static void main(String[] args) {
        PrintStream out = System.out;

        MyPrintStream myPrintStream = new MyPrintStream();
        System.setOut(myPrintStream);
        print(new int[]{1, 2, 3});

        System.setOut(out);
        System.out.println("1, 2, 3, ".equals(myPrintStream.getContent()));
    }

    static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}