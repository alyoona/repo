package com.stroganova.synchronization;

public class Resource {
    int i;

    private Object MONITOR;

    public Resource(Object MONITOR) {
        this.MONITOR = MONITOR;
    }

    void increment() {

        synchronized (MONITOR) {
            i++;
        }
    }
}
