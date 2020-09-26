package org.example;

public class Comment {
    private short postId;
    private short id;
    private String name;
    private String email;
    private String body;


    // Getter Methods

    public String getEmail() {
        return email;
    }

    // Setter Methods

    public void setPostId(short postId) {
        this.postId = postId;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
