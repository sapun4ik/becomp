package me.becomp.web.validation;

import me.becomp.web.dto.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by sapun4ik on 18.03.2018.
 */
public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto user = (UserDto) obj;
        if (user.getPassword() == null || user.getMatchingPassword()== null) return false;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
