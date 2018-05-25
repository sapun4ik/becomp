package me.becomp.security.registration;

import me.becomp.persistence.model.security.User;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {

    private final String appUrl;
    private final Locale locale;
    private final User user;

    public OnRegistrationCompleteEvent(final User user, final Locale locale, final String appUrl) {
        super(user);
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public User getUser() {
        return user;
    }

}
