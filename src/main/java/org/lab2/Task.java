package org.lab2;
import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    private final String id;

    public Task(String id) {
        this.id = id;
    }

    @Override
    public Integer call() throws Exception {
        // Симуляція обчислення
        System.out.println("Task " + id + " is running...");
        Thread.sleep(2000); // Затримка для імітації обчислення
        return id.hashCode(); // Повертаємо результат
    }

    public String getId() {
        return id;
    }
}
