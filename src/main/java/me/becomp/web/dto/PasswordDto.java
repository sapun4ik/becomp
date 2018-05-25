package me.becomp.web.dto;

import me.becomp.web.validation.ValidPassword;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public class PasswordDto {

    private String oldPassword;

    @ValidPassword
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
