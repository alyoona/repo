package com.stroganova.serverio;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader socketBufferedReader =
                         new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedWriter socketBufferedWriter = new BufferedWriter(
                         new OutputStreamWriter(socket.getOutputStream()))) {

                String lineFromClient;
                while ((lineFromClient = socketBufferedReader.readLine()) != null) {
                    socketBufferedWriter.write("echo" + lineFromClient);
                    socketBufferedWriter.newLine();
                    socketBufferedWriter.flush();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}