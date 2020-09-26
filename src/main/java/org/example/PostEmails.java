package org.example;

import java.util.List;


// creating a post object with email list
public class PostEmails {
    private float postid;
    private List<Comment> emails; // getting a list in comment type

    public List<Comment> getEmails() {
        return emails;
    }

    public void setEmails(List<Comment> emails) {
        this.emails = emails;
    }
// Getter Methods 

    public float getPostid() {
        return postid;
    }

    // Setter Methods 

    public void setPostid(float postid) {
        this.postid = postid;
    }
}
