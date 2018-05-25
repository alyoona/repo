package com.stroganova.serverio;

import java.net.*;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        List<Socket> clientList = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientList.add(clientSocket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Runnable clientListHandler = new ClientListHandler(clientList);
        Thread thread = new Thread(clientListHandler);
        thread.start();
    }
}