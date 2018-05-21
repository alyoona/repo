package com.stroganova.io;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

class MyPrintStream extends PrintStream {
    private StringBuilder content = new StringBuilder();

    public MyPrintStream() {
        this(null);
    }

    public MyPrintStream(OutputStream out) {
        super(new ByteArrayOutputStream());
    }

    @Override
    public void print(String s) {
        content.append(s);
    }

    public String getContent() {
        return content.toString();
    }
}
