package com.stroganova.serverio;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerWeb {
//    public static void main(String[] args) throws Exception {
//        ServerSocket serverSocket = new ServerSocket(3000);
//        Socket socket = serverSocket.accept();
//        BufferedReader bufferedReader =
//                new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String value;
//        while (!(value = bufferedReader.readLine()).isEmpty()) {
//            System.out.println(value);
//        }
//
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//        bufferedWriter.write("HTTP/1.1 200 OK\r\n");
//        bufferedWriter.write("\r\n");
//        bufferedWriter.write("Hello world");
//        bufferedWriter.close();
//    }
//
//    public void setPort(int i) {
//    }
//
//    public void setWebAppPath(String wabapp) {
//    }
//
//    public void start() {
//    }

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String value;
        while (!(value = bufferedReader.readLine()).isEmpty()) {
            System.out.println(value);
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("HTTP/1.1 200 OK\r\n");
        bufferedWriter.write("\r\n");
        bufferedWriter.write("Hello world");
        bufferedWriter.close();
    }
}
