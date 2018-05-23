package com.stroganova.serverio;

import java.io.*;
import java.net.Socket;

public class CurrentClientProcessing implements Runnable {

    private Socket clientSocket;

    public CurrentClientProcessing(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (
             BufferedReader socketBufferedReader =
                     new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter socketBufferedWriter = new BufferedWriter(
                     new OutputStreamWriter(clientSocket.getOutputStream()))) {
            String lineFromClient;
            while ((lineFromClient = socketBufferedReader.readLine()) != null) {
                System.out.println(lineFromClient);
                String internalServerMessage = statusMessage(lineFromClient);
                System.out.println(internalServerMessage);
                System.out.println();
                String answerForClient = answerForClient(internalServerMessage);
                socketBufferedWriter.write(answerForClient);
                socketBufferedWriter.newLine();
                socketBufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String statusMessage(String lineFromClient) {
        String[] array = lineFromClient.split(":");
        String[] array0 = array[0].split(" ");
        String clientName  = array0[3];
        String messageNumber = array0[1];
        StringBuilder builder = new StringBuilder("Answer for ");
        builder.append(clientName);
        builder.append(": echo");
        builder.append(messageNumber);
        builder.append(array[1]);
        return builder.toString();
    }

    private static String answerForClient(String statusMessage) {
        String[] array = statusMessage.split(":");
        return array[1].trim();
    }
}
