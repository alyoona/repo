package com.stroganova.serverio.client;

import java.io.*;

public class ClientWriter {

    private BufferedReader consoleReader;
    private BufferedWriter socketWriter;

    public ClientWriter(BufferedReader consoleReader, BufferedWriter socketWriter) {
        this.consoleReader = consoleReader;
        this.socketWriter = socketWriter;
    }

    public void sendMessage() {
        try {
            String line = consoleReader.readLine();
            socketWriter.write(line);
            socketWriter.newLine();
            socketWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error while sending message to server, ", e);
        }
    }
}

