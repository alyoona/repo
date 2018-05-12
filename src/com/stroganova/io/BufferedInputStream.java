package com.stroganova.io;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream {
    private static int DEFAULT_BUFFER_SIZE = 5;

    private InputStream inputStream;
    private byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
    private int index;
    private int count;

    public BufferedInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        if(index == count) {
            count = inputStream.read(buffer);
            index = 0;
        }
          if(count == -1) {
              return -1;
          }
        return buffer[index++];
    }
}
