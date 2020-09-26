package org.example;

import java.util.List;

// creating a user object with postemail list and add the user id
public class userPosts {
    private byte userId;
    private List<PostEmails> posts; // getting a list in a postmail type , which contains the post id and the email list that commented on the post

    public byte getUserId() {
        return userId;
    }

    public void setUserId(byte userId) {
        this.userId = userId;
    }

    public List<PostEmails> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEmails> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "userPosts{" +
                "userId=" + userId +
                ", posts=" + posts +
                '}';
    }
}
