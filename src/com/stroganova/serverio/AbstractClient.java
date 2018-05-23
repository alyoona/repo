package com.stroganova.serverio;

import java.io.*;
import java.net.Socket;

public class AbstractClient {

    private String clientName;

    public void go() {
        try (
                Socket socket = new Socket("localhost", 3000);
                BufferedWriter socketBufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader socketBufferedReader =
                        new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader consoleBufferedReader =
                        new BufferedReader(new InputStreamReader(System.in));
        ) {
            int count = 1;
            while (true) {
                String line = consoleBufferedReader.readLine();
                String messageForServer = messageForServer(line, count);
                socketBufferedWriter.write(messageForServer);
                socketBufferedWriter.newLine();
                socketBufferedWriter.flush();
                System.out.println(socketBufferedReader.readLine());
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    private String messageForServer(String lineFromConsole, int messageNumber) {
        StringBuilder builder = new StringBuilder("Message #");
        builder.append(messageNumber);
        builder.append(" from ");
        builder.append(clientName);
        builder.append(": ");
        builder.append(lineFromConsole);
        return builder.toString();
    }
}

