package com.mycompany.taskmanager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();
        int userChoice;
        do {
            taskManager.showMenu();
            try {
                userChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not valid input");
                userChoice = 6;
            }
            switch (userChoice) {
                case 1:
                    Task newTask = new Task();
                    newTask.addTask();
                    list.add(newTask);
                    System.out.println("Task is added!");
                    break;
                case 2:
                    System.out.println("\nList of all tasks:");
                    for (Task listItem : list) {
                        System.out.printf("ID=%d, Description: %s\n", listItem.getTaskNumber(), listItem.getTaskDescription());
                    }
                    break;
                case 3:
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
                    break;
                case 4:
                    System.out.println("\nList of not finished tasks:");
                    for (Task listItem : list) {
                        if (!listItem.isFinished())
                            System.out.printf("ID=%d, Description: %s\n", listItem.getTaskNumber(), listItem.getTaskDescription());
                    }
                    break;
                case 5:
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
                    break;
                default: {
                    System.out.println("End of program");
                }
            }
            System.out.println();
        } while (userChoice > 0 & userChoice < 6);
    }
}





