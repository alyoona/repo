package com.stroganova.multithreading;

import org.junit.Test;

public class TimerTest {
   // @Test
   public static void main(String[] args) {

        Thread thread = new Thread(new Timer("First timer", 20));
        thread.start();

//        Timer t = new Timer("First timer", 20);
//        t.run();
    }
}
