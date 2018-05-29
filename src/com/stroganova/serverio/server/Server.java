package com.stroganova.serverio.server;


import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        List<Socket> list = new ArrayList<>();
        Runnable clientHandlerListener = new ClientListHandler(list);
        Thread thread = new Thread(clientHandlerListener);
        thread.start();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            synchronized (list) {
                list.add(clientSocket);
            }

        }
    }
}