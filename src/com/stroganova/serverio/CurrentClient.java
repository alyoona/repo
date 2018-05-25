package com.stroganova.serverio;

import java.io.InputStream;
import java.net.Socket;

public class CurrentClient {

    private Socket clientSocket;
    private boolean ready;

    public CurrentClient(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public boolean isReady() {

    try(
    InputStream is = clientSocket.getInputStream())

    {

    }
}
}
