package me.becomp.security.service;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
