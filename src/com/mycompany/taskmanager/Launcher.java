package com.mycompany.taskmanager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        ArrayList<Task> list = new ArrayList<>();
        int userChoice;
        do {
            taskManager.showMenu();
            try {
                Scanner scanner = new Scanner(System.in);
                userChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not valid input");
                userChoice = 6;
            }
            switch (userChoice) {
                case 1:
                    taskManager.addTask(new Task(), list);
                    break;
                case 2:
                    taskManager.showAllTasks(list);
                    break;
                case 3:
                    taskManager.showFinishedTasks(list);
                    break;
                case 4:
                    taskManager.showNotFinishedTasks(list);
                    break;
                case 5:
                    taskManager.markTaskAsFinished(list);
                    break;
                default: {
                    System.out.println("End of program");
                }
            }
            System.out.println();
        } while (userChoice > 0 & userChoice < 6);
    }
}





