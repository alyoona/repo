package com.stroganova;

import java.io.IOException;

/**
 * Created by YONA on 29.05.2018.
 */
public class Test {
    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (IOException e) {
                throw new RuntimeException("thrown my IOExeption: ", e);
        } finally {
            System.out.println("finally");
        }
    }
}
