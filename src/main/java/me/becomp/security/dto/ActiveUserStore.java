package me.becomp.security.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public class ActiveUserStore {

    public List<String> users;

    public ActiveUserStore() {
        users = new ArrayList<String>();
    }

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
