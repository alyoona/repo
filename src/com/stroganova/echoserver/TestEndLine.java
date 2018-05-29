package com.stroganova.echoserver;

import java.io.*;

public class TestEndLine {
    public static void main(String[] args) throws IOException {
        BufferedReader socketReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int firstChar = socketReader.read();
        while (socketReader.ready()) {
            String msg = (char) firstChar + socketReader.readLine();
            socketWriter.write("echo: " + msg);
            //socketWriter.newLine();
           // socketWriter.newLine();
            socketWriter.flush();
            firstChar = socketReader.read();
        }
    }
}

