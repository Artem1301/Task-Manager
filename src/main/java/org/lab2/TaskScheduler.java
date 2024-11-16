package org.lab2;

import java.util.concurrent.*;

public class TaskScheduler {
    private final ExecutorService executor;

    public TaskScheduler(int threadPoolSize) {
        this.executor = Executors.newFixedThreadPool(threadPoolSize);
    }

    public Future<Integer> scheduleTask(Task task) {
        return executor.submit(task);
    }

    public void shutdown() {
        executor.shutdown();
    }

    public void shutdownNow() {
        executor.shutdownNow();
    }
}
