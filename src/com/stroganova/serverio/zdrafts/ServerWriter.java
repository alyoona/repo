package com.stroganova.serverio.zdrafts;

import java.io.BufferedWriter;
import java.io.IOException;

public class ServerWriter {
    private BufferedWriter socketWriter;

    public ServerWriter(BufferedWriter socketWriter) {
        this.socketWriter = socketWriter;
    }

    public void sendMessageToClient(String message) {
        try {
            socketWriter.write(message);
            socketWriter.newLine();
            socketWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error while sending message to client: ", e);
        }
    }
}
