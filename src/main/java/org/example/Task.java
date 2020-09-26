package org.example;

public class Task {
    private byte userId;
    private short id;
    private String title;
    private boolean completed;


    // Getter Methods

    public short getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Setter Methods 

    public void setUserId(byte userId) {
        this.userId = userId;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Uncompleted Task{" +
                ", id=" + id +
                ", title='" + title +
                '}';
    }
}
