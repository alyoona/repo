package com.stroganova.serverio;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientListHandler implements Runnable {
    List<Socket> clientList = new ArrayList<>();

    public ClientListHandler(List<Socket> clientList) {
        this.clientList = clientList;
    }

    @Override
    public void run() {
        int socketIndex = 0;
        for (Socket clientSocket : clientList) {
            if (!clientSocket.isClosed()) {

            } else {
                clientList.remove(socketIndex);
            }
        }
    }

    get activeClients() {
        return
    }
}
