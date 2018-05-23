package com.stroganova.serverio;

public class SecondClient extends AbstractClient {

    public static void main(String[] args) {
        SecondClient secondClient = new SecondClient();
        secondClient.setClientName("AnotherClient");
        System.out.println("I'm AnotherClient");
        secondClient.go();
    }
}
