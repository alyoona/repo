package com.stroganova.serverio;

import java.io.InputStream;
import java.net.*;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class Server {

    //Runnable currentClientHandling = new CurrentClientProcessing(clientSocket);
    // Thread threadForClientProcessing = new Thread(currentClientHandling);
    //  threadForClientProcessing.start();

    public static void main(String[] args) {
        List<CurrentClientProcessing> clientList = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientList.add(new CurrentClientProcessing(clientSocket));
                int clientIndex = 0;
                for(CurrentClientProcessing client : clientList) {
                    clientIndex++;
                        //if(client.isReady()) {
                            Thread threadForClientProcessing = new Thread(client);
                            threadForClientProcessing.start();
                            //while(client.isReady()) {
                                threadForClientProcessing.join();
                            //}
                        //}


                    SocketChannel
                    } else {
                        clientList.remove(clientIndex);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}