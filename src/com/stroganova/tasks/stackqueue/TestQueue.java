package com.stroganova.tasks.stackqueue;

/**
 * Created by YONA on 23.04.2018.
 */
public class TestQueue {
    public static void main(String[] args) {

        ArrayQueue q = new ArrayQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.toString());
        q.dequeue();

        System.out.println(q.toString());
        q.enqueue(4);

        System.out.println(q.toString());
    }
}
