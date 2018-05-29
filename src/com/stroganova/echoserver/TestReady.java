package com.stroganova.echoserver;

import java.io.*;

public class TestReady {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleBufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        int firstSymbol = 0;
        String line = null;
        while (true) {
            firstSymbol = consoleBufferedReader.read();
            if (consoleBufferedReader.ready()) {
                System.out.println("symbol: " + (char) firstSymbol);
                line = consoleBufferedReader.readLine();
                System.out.println("rest of line: " + line);
                System.out.println("together: " + (char) firstSymbol + line);
            }
        }
    }
}
