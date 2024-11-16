package org.lab2;
import java.util.Scanner;

public class UserInterface {
    private final ComputationManager manager;

    public UserInterface(ComputationManager manager) {
        this.manager = manager;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Computation Manager!");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            try {
                switch (command[0]) {
                    case "group":
                        manager.createGroup(command[1]);
                        System.out.println("Group " + command[1] + " created.");
                        break;
                    case "new":
                        Task task = new Task(command[1]);
                        manager.addTaskToGroup(command[2], task);
                        System.out.println("Task " + command[1] + " added to group " + command[2]);
                        break;
                    case "run":
                        manager.runGroup(command[1]);
                        break;
                    case "exit":
                        manager.shutdown();
                        System.out.println("Shutting down...");
                        return;
                    default:
                        System.out.println("Unknown command.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
