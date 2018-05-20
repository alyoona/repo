package com.stroganova.reflection.methods;

import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;

public class E extends D implements Serializable, Closeable {

    private byte b = 10;
    private short s = 10;
    private int i = 10;
    private long l = 10;
    private float f = 10;
    private double d = 10;
    private char c = 'k';
    private boolean bool = true;
    private String objectField = new String("test");

    @Override
    public void close() throws IOException {
        System.out.println("method close()");
    }
    @Run
    public void methodOne() {
        System.out.println("methodOne() annotated by @Run");
    }

    final void methodTwo() {
        System.out.println("methodTwo()");
    }

    void printInt(int value) {
        System.out.println(value);
    }
}
