package com.stroganova.serverio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        String value = "Hello client";
        try (Socket socket = serverSocket.accept();
             OutputStream outputStream = socket.getOutputStream();) {
            outputStream.write(value.getBytes());
        }
    }
}