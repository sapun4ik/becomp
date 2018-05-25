package me.becomp.persistence.model.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by sapun4ik on 18.03.2018.
 */
@Entity
@Table(name = "persistent_logins")
public class PersistentLogins {
   private String username;
   @Id
    private String series;
    private String token;
    private Timestamp last_used;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getLast_used() {
        return last_used;
    }

    public void setLast_used(Timestamp last_used) {
        this.last_used = last_used;
    }
}
