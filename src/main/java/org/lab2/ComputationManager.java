package org.lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

public class ComputationManager {
    private final Map<String, TaskGroup> groups = new HashMap<>();
    private final TaskScheduler scheduler;

    public ComputationManager(int threadPoolSize) {
        this.scheduler = new TaskScheduler(threadPoolSize);
    }

    public void createGroup(String groupId) {
        groups.putIfAbsent(groupId, new TaskGroup(groupId));
    }

    public void addTaskToGroup(String groupId, Task task) {
        TaskGroup group = groups.get(groupId);
        if (group == null) {
            throw new IllegalArgumentException("Group " + groupId + " does not exist!");
        }
        Future<Integer> future = scheduler.scheduleTask(task);
        group.addTask(future);
    }

    public void runGroup(String groupId) throws InterruptedException {
        TaskGroup group = groups.get(groupId);
        if (group == null) {
            throw new IllegalArgumentException("Group " + groupId + " does not exist!");
        }

        for (Future<Integer> future : group.getTasks()) {
            try {
                System.out.println("Result: " + future.get());
            } catch (Exception e) {
                System.err.println("Task failed or was cancelled.");
            }
        }
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
