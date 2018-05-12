package com.stroganova.io;
import java.io.IOException;
import java.io.OutputStream;


public class BufferedOutputStream extends OutputStream {
    private static int DEFAULT_BUFFER_SIZE = 5;
    private OutputStream outputStream;
    private byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
    private int count;
    private int index;
    public BufferedOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        if (count >= buffer.length) {
            flush();
        }
        buffer[count++] = (byte) b;
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
      index = off;
      while(index < (off + len)) {
            write(b[index++]);
        }
    }

    @Override
    public void flush() throws IOException {
        if (count > 0) {
        outputStream.write(buffer, 0, count);
        count = 0;
        }
    }

    @Override
    public void close() throws IOException {
        flush();
        outputStream = null;
    }


}