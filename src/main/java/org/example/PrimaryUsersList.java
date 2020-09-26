package org.example;

import java.util.List;

public class PrimaryUsersList {
    private List<UncompletedUser> users; //creating a user list which contains a user id and the uncompleted tasks
    
    
    public List<UncompletedUser> getUsers() {
        return users;
    }

    public void setUsers(List<UncompletedUser> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "PrimaryUsersList{" +
                "users=" + users +
                '}';
    }
}

