package org.example;

public class albums {
    private byte userId;
    private byte id;
    private String title;


    public byte getUserId() {
        return userId;
    }

    public byte getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    // Setter Methods

    public void setUserId(byte userId) {
        this.userId = userId;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
