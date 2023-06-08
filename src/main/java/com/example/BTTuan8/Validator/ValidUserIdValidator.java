package com.example.BTTuan8.Validator;

import com.example.BTTuan8.Validator.annotation.ValidUserId;
import com.example.BTTuan8.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public  boolean isValid(User user, ConstraintValidatorContext context)
    {
        if(user == null)
            return true;
        return user.getUser_id() != null;
    }
}
