package org.example;

public class Post {
    private short id;
    private byte userId;
    private String title;
    private String body;

    public void setUserId(byte userId) {
        this.userId = userId;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Postim{" +
                ", id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
