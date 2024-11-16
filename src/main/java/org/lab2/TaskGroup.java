package org.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class TaskGroup {
    private final String groupId;
    private final List<Future<Integer>> tasks;

    public TaskGroup(String groupId) {
        this.groupId = groupId;
        this.tasks = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public void addTask(Future<Integer> task) {
        tasks.add(task);
    }

    public List<Future<Integer>> getTasks() {
        return tasks;
    }
}
