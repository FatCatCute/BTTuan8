package com.example.BTTuan8.Validator;

import com.example.BTTuan8.Validator.annotation.ValidUsername;
import com.example.BTTuan8.Repository.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    private IUserRepository userRepository;
    public  boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository == null)
            return  true;
        return  userRepository.findByUsername(username) == null;
    }
}
