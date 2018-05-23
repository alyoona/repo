package com.stroganova.serverio;

public class FirstClient extends AbstractClient {

    public static void main(String[] args) {
        FirstClient firstClient = new FirstClient();
        firstClient.setClientName("OneClient");
        System.out.println("I'm OneClient");
        firstClient.go();
    }
}
