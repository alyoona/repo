package com.stroganova.multithreading;


import com.stroganova.multithreading.Timer;

public class Test {

    public static void main(String[] args) throws NoSuchFieldException {
        Thread thread = new Thread(new Timer("First timer", 20));
        thread.start();
    }
}

