package com.stroganova.serverio.client;

import java.io.*;

public class ClientReader {

    private BufferedReader socketReader;

    public ClientReader(BufferedReader socketReader) {
        this.socketReader = socketReader;
    }

    public void printAnswerFromServer() {
        try {
            System.out.println("Server answer: " + socketReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Error while reading message from server, ", e);
        }
    }
}
