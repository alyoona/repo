package com.stroganova.serverio.server;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientListHandler implements Runnable {
    private List<Socket> clientList;

    public ClientListHandler(List<Socket> clientList) {
        this.clientList = clientList;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (clientList.size() > 0) {
                System.out.println("count client added: " + clientList.size());
                break;
            }
        }
        System.out.println("out of waiting client loop");
        while (true) {

            synchronized (clientList) {
                for (Socket socket : clientList) {
                    try {
                        Socket clientSocket = socket;
                        BufferedReader socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                        int firstChar = socketReader.read();
                        while (socketReader.ready()) {
                            String msg = (char) firstChar + socketReader.readLine();
                            socketWriter.write("echo: " + msg);
                            socketWriter.newLine();
                            socketWriter.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

