package com.ra.model.service.validator;

import com.ra.model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class CheckPhoneExist implements ConstraintValidator<UserValidator,String> {
    @Autowired
    private UserService userService;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !userService.checkPhoneExist(s);
    }

}
