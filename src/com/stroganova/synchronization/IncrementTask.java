package com.stroganova.synchronization;

public class IncrementTask implements Runnable {
    Resource resource;

    public IncrementTask(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1; i++) {
            resource.increment();
        }

    }
}
