package com.stroganova.serverio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class ServerInOut {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        InputStream in = System.in;
        InputStreamReader isr= new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);

    }
}
