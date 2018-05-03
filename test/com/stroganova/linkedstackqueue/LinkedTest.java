package com.stroganova.linkedstackqueue;

/**
 * Created by dp-ptcstd-15 on 4/24/2018.
 */
public class LinkedTest {

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            linkedQueue.enqueue(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(linkedQueue.dequeue());
        }
    }
}

