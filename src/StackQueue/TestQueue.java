package StackQueue;

/**
 * Created by YONA on 23.04.2018.
 */
public class TestQueue {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.toString();
        System.out.println(queue.toString());
        queue.enqueue("A");
        queue.enqueue("B");
        System.out.println(queue.toString());

    }
}
