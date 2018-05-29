package com.stroganova.serverio.zdrafts;

import java.io.BufferedReader;
import java.io.IOException;

public class ServerReader {

    private BufferedReader socketReader;
    private char firstSymbol;

    public ServerReader(BufferedReader socketReader) {
        this.socketReader = socketReader;
    }

    public boolean isThereSomethingNewFromClient() {
        try {
            firstSymbol = (char) socketReader.read();
            return socketReader.ready();
        } catch (IOException e) {
            throw new RuntimeException("Error while checking available message from client", e);
        }
    }

    public String readMessageFromClient() {
        try {
            return firstSymbol + socketReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error while reading message from client", e);
        }
    }
}
