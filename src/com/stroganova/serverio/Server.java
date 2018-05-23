package com.stroganova.serverio;

import java.net.*;

public class Server {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                    Runnable currentClientHandling = new CurrentClientProcessing(clientSocket);
                    Thread threadForClientProcessing = new Thread(currentClientHandling);
                    threadForClientProcessing.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}