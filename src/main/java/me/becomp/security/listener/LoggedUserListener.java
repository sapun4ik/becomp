package me.becomp.security.listener;

import me.becomp.security.dto.ActiveUserStore;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.List;

/**
 * Created by sapun4ik on 18.03.2018.
 */
@Component
public class LoggedUserListener implements HttpSessionBindingListener {

    private String username;
    private ActiveUserStore activeUserStore;

    public LoggedUserListener(String username, ActiveUserStore activeUserStore) {
        this.username = username;
        this.activeUserStore = activeUserStore;
    }

    public LoggedUserListener() {
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(activeUserStore);
        List<String> users = activeUserStore.getUsers();
        LoggedUserListener user = (LoggedUserListener) event.getValue();
        if (!users.contains(user.getUsername())) {
            users.add(user.getUsername());
        }
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        List<String> users = activeUserStore.getUsers();
        LoggedUserListener user = (LoggedUserListener) event.getValue();
        if (users.contains(user.getUsername())) {
            users.remove(user.getUsername());
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
