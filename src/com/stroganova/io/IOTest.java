package com.stroganova.io;

import java.io.InputStream;

public class IOTest {
    public static void main(String[] args) {
        try {
            InputStream inputStream = FileUtils.getStreamForFile("test.log");
            int value;
            while ((value = inputStream.read()) != -1) {
                System.out.println(value);
            }
        } catch (RuntimeException e) {
            System.err.println("Runtime!!");
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        } catch (Exception e) {
            System.err.println("Exception!!!");
            e.printStackTrace();
        }
    }
}
