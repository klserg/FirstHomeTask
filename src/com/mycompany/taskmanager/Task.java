package com.mycompany.taskmanager;

public class Task {
    private String taskDescription;
    private boolean isFinished;
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

    public void setTaskDescription(String description) {
        taskDescription = description;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public Task setStatus(Boolean status) {
        isFinished = true;
        return this;
    }
}

