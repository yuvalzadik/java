package org.example;

import java.util.List;

public class UncompletedUser {
    private byte userId;
    private List<Task> tasks;

    public byte getUserId() {
        return userId;
    }

    public void setUserId(byte userId) {
        this.userId = userId;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "UncompletedUser{" +
                "userId=" + userId +
                ", tasks=" + tasks +
                '}';
    }
}
