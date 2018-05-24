package com.stroganova.synchronization;

public class SynchroTest {

    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        int hashCodeMonitor = monitor.hashCode();
        //https://www.ibm.com/developerworks/library/j-codetoheap/index.html#fig2
        Resource resource = new Resource(monitor);
        Thread thread1 = new Thread(new IncrementTask(resource));
        //Thread thread2 = new Thread(new IncrementTask(resource));

        thread1.start();
        //thread2.start();

       thread1.join();
       //thread2.join();
        System.out.println("MONITOR hashcode: " + hashCodeMonitor);
        System.out.println(resource.i);
    }

}
