package org.example;

import java.util.List;

// creating the primary collection of all the userse
public class userPostReplierEmails {
    private List<userPosts> usersPosts; //getting a user list which contains a user id and the list of posts with list of emails

    public List<userPosts> getUsersPosts() {
        return usersPosts;
    }

    public void setUsersPosts(List<userPosts> usersPosts) {
        this.usersPosts = usersPosts;
    }

    @Override
    public String toString() {
        return "userPostReplierEmails{" +
                "usersPosts=" + usersPosts +
                '}';
    }
}
