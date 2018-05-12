package com.stroganova;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class Test {

    public static void main(String[] args) throws IOException {



        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("test_copy.log"));

        String helloWorld = "Hello";

        outputStream.write(helloWorld.getBytes());
        outputStream.close();
    }




}

