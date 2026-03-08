package com.darion;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private static final String FILE_NAME = "tasks.json";

    private List<Task> tasks = new ArrayList<>();

    public TaskManager() {
        loadTasks();
    }

    private String now() {
        return LocalDateTime.now().withNano(0).toString();
    }

    private void loadTasks() {

        Path path = Paths.get(FILE_NAME);

        try {

            if (!Files.exists(path)) {
                Files.writeString(path, "[]");
                return;
            }

            String content = Files.readString(path);

            if (content.equals("[]") || content.isEmpty()) {
                return;
            }

        } catch (IOException e) {
            System.out.println("Error loading tasks");
        }
    }

    private void saveTasks() {

        StringBuilder json = new StringBuilder();

        json.append("[\n");

        for (int i = 0; i < tasks.size(); i++) {

            json.append(tasks.get(i).toJson());

            if (i < tasks.size() - 1) {
                json.append(",");
            }

            json.append("\n");
        }

        json.append("]");

        try {
            Files.writeString(Paths.get(FILE_NAME), json.toString());
        } catch (IOException e) {
            System.out.println("Error saving tasks");
        }
    }

    private int getNextId() {

        int max = 0;

        for (Task task : tasks) {

            if (task.getId() > max) {
                max = task.getId();
            }
        }

        return max + 1;
    }

    public void addTask(String description) {

        String time = now();

        Task task = new Task(
                getNextId(),
                description,
                "todo",
                time,
                time
        );

        tasks.add(task);

        saveTasks();

        System.out.println("Task added successfully (ID: " + task.getId() + ")");
    }

    public void listTasks() {

        if (tasks.isEmpty()) {

            System.out.println("No tasks found");

            return;
        }

        for (Task task : tasks) {

            System.out.println(task);
        }
    }

    public void markTask(int id, String status) {

        for (Task task : tasks) {

            if (task.getId() == id) {

                task.setStatus(status);

                task.setUpdatedAt(now());

                saveTasks();

                System.out.println("Task updated");

                return;
            }
        }

        System.out.println("Task not found");
    }

    public void deleteTask(int id) {

        tasks.removeIf(task -> task.getId() == id);

        saveTasks();

        System.out.println("Task deleted");
    }
}