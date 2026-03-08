package com.darion;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        if (args.length == 0) {
            System.out.println("No command provided");
            return;
        }

        String command = args[0];

        switch (command) {

            case "add":
                manager.addTask(args[1]);
                break;

            case "list":
                manager.listTasks();
                break;

            case "mark-done":
                manager.markTask(Integer.parseInt(args[1]), "done");
                break;

            case "mark-in-progress":
                manager.markTask(Integer.parseInt(args[1]), "in-progress");
                break;

            case "delete":
                manager.deleteTask(Integer.parseInt(args[1]));
                break;

            default:
                System.out.println("Unknown command");
        }
    }
}