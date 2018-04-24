package StackQueue;

/**
 * Created by YONA on 23.04.2018.
 */
public class TestQueue {
    public static void main(String[] args) {

        System.out.println("ArrayQueueImproved");
        ArrayQueueImp queueImp = new ArrayQueueImp();
        System.out.println(queueImp.toString());
        queueImp.enqueue("1");
        System.out.println(queueImp.toString());
        queueImp.enqueue("2");
        System.out.println(queueImp.toString());
        queueImp.enqueue("3");
        System.out.println(queueImp.toString());
        System.out.println(queueImp.dequeue());
        System.out.println(queueImp.toString());
        queueImp.enqueue("4");
        queueImp.enqueue("5");
        queueImp.enqueue("6");
        queueImp.enqueue("7");
        queueImp.enqueue("8");

        System.out.println(queueImp.toString());


    }
}
