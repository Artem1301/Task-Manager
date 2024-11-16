package org.lab2;

public class Main {
    public static void main(String[] args) {
        ComputationManager manager = new ComputationManager(4);
        UserInterface ui = new UserInterface(manager);
        ui.start();
    }
}
