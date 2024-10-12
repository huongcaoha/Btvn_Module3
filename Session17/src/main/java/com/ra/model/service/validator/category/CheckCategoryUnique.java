package com.ra.model.service.validator.category;

import com.ra.controller.CategoryController;
import com.ra.model.service.category.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class CheckCategoryUnique implements ConstraintValidator<CategoryUnique,String> {
    private final CategoryServiceImpl categoryServiceImpl;

    @Autowired
   public CheckCategoryUnique(CategoryServiceImpl categoryServiceImpl){
        this.categoryServiceImpl = categoryServiceImpl;
    }
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !categoryServiceImpl.checkNameExist(s, CategoryController.cateOldName);
    }
}
