package com.example.BTTuan8.Validator;

import com.example.BTTuan8.Validator.annotation.ValidCategoryId;
import com.example.BTTuan8.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return category!= null && category.getId()!=null;
    }

}
