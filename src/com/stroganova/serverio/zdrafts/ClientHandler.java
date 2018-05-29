package com.stroganova.serverio.zdrafts;

import java.io.*;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void handle(BufferedReader socketReader, BufferedWriter socketWriter) {
            ServerReader serverReader = new ServerReader(socketReader);
            ServerWriter serverWriter = new ServerWriter(socketWriter);
                String message = serverReader.readMessageFromClient();
                serverWriter.sendMessageToClient("echo" + message);

    }

    public boolean isProcessable() {
        try (BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            ServerReader serverReader = new ServerReader(socketReader);
            return serverReader.isThereSomethingNewFromClient();
        } catch (IOException e) {
            throw new RuntimeException("Error while checking client processability", e);
        }
    }

}
