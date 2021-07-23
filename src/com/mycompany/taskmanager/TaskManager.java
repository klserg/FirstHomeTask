package com.mycompany.taskmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {

    public void showMenu() {
        System.out.println("Task manager menu:");
        System.out.println("1. Add task");
        System.out.println("2. Show all task list");
        System.out.println("3. Show list of finished tasks");
        System.out.println("4. Show list of not finished tasks");
        System.out.println("5. Mark task as done");
        System.out.println("6. Quit");
        System.out.print("Enter number of your choice:");
    }

    public void addTask(Task newTask, ArrayList<Task> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task message:");
        String taskDescription = scanner.nextLine();
        newTask.setTaskDescription(taskDescription);
        list.add(newTask);
        System.out.println("Task is added!");
    }

    public void showAllTasks(ArrayList<Task> list) {
        System.out.println("\nList of all tasks:");
        for (Task listItem : list) {
            System.out.printf("ID=%d, Description: %s\n", listItem.getTaskNumber(), listItem.getTaskDescription());
        }
    }

    public void showFinishedTasks(ArrayList<Task> list) {
        System.out.println("\nList of finished tasks:");
        int count = 0;
        for (Task listItem : list) {
            if (listItem.isFinished()){
                count++;
                System.out.printf("ID=%d, Description: %s\n", listItem.getTaskNumber(), listItem.getTaskDescription());
            }
        }
        if (count == 0)
            System.out.println("List is empty");
    }

    public void showNotFinishedTasks(ArrayList<Task> list) {
        System.out.println("\nList of not finished tasks:");
        for (Task listItem : list) {
            if (!listItem.isFinished())
                System.out.printf("ID=%d, Description: %s\n", listItem.getTaskNumber(), listItem.getTaskDescription());
        }
    }

    public void markTaskAsFinished(ArrayList<Task> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ID of finished task: ");
        int number = scanner.nextInt();
        if (number > list.size())
            System.out.println("Task with this ID doesn't exist");
        else {
            for (Task listItem : list) {
                if (listItem.getTaskNumber() == number) {
                    if (listItem.isFinished())
                        System.out.println("Task with this ID is already finished");
                    else {
                        listItem.setStatus(true);
                        System.out.printf("Task with ID=%d is marked as done!\n", listItem.getTaskNumber());
                    }
                }
            }
        }
    }
}
