package com.stroganova.echoserver;

import java.io.*;
import java.net.Socket;

public class simpleClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 3000);
        BufferedWriter socketBufferedWriter = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader socketBufferedReader =
               new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader consoleBufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = consoleBufferedReader.readLine();
            socketBufferedWriter.write(line);
            socketBufferedWriter.newLine();
            socketBufferedWriter.flush();
            System.out.println(socketBufferedReader.readLine());
        }
    }
}
