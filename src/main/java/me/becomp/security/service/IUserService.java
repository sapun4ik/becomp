package me.becomp.security.service;

import me.becomp.persistence.model.security.PasswordResetToken;
import me.becomp.persistence.model.security.User;
import me.becomp.persistence.model.security.VerificationToken;
import me.becomp.web.dto.UserDto;
import me.becomp.web.exception.UserAlreadyExistException;

import java.util.List;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    User getUserByPasswordResetToken(String token);

    User getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);

    List<String> getUsersFromSessionRegistry();

}