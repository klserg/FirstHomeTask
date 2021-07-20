import java.util.Scanner;

public class Task {
    private String taskDescription = null;
    private boolean isFinished = false;
    private int taskNumber = 1;
    private static int count = 1;

    public Task() {
    taskNumber = count++;
    }

    public int getTaskNumber() {
    return taskNumber;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Task setStatus(Boolean status) {
        isFinished = true;
        return this;
    }

    public Task addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task message:");
        taskDescription = scanner.nextLine();
        return this;
    }
}

