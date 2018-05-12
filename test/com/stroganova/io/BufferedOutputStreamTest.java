package com.stroganova.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;


public class BufferedOutputStreamTest {

    OutputStream outputStream;

    @Before
    public void before() {
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream("test.log"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException("error during openning file", e);
        }
    }

    @After
    public void after() {
    }

    @Test
    public void testWriteByte() {
        System.out.println("start");
        try {
            String str = "0123456789";

            outputStream.write(str.getBytes(), 9, 1);

            outputStream.close();
            outputStream.write(102);

        } catch (IOException e) {
            throw new RuntimeException("error during writing into a file", e);
        }

    }

}
