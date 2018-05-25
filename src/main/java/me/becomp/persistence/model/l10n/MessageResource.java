package me.becomp.persistence.model.l10n;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sapun4ik on 03.06.2017.
 */
@Entity
@Table(name = "message_resource")
public class MessageResource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "messageKey", nullable = false)
   // @Column(name = "messageKey", nullable = true)
    private String messageKey;
    @Column(name = "en", nullable = true)
    private String english;
    @Column(name = "ru", nullable = true)
    private String russian;

    public MessageResource() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getRussian() {
        return russian;
    }

    public void setRussian(String russian) {
        this.russian = russian;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageResource that = (MessageResource) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (messageKey != null ? !messageKey.equals(that.messageKey) : that.messageKey != null) return false;
        if (english != null ? !english.equals(that.english) : that.english != null) return false;
        return russian != null ? russian.equals(that.russian) : that.russian == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (messageKey != null ? messageKey.hashCode() : 0);
        result = 31 * result + (english != null ? english.hashCode() : 0);
        result = 31 * result + (russian != null ? russian.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MessageResource{" +
                "id=" + id +
                ", messageKey='" + messageKey + '\'' +
                ", english='" + english + '\'' +
                ", russian='" + russian + '\'' +
                '}';
    }
}
