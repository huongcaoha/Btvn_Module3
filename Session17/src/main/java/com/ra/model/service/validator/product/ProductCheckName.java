package com.ra.model.service.validator.product;

import com.ra.controller.ProductController;
import com.ra.model.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
@Component
public class ProductCheckName implements ConstraintValidator<ProductUnique,String> {
    @Autowired
    private ProductService productService ;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !productService.checkNameExist(s, ProductController.productOldName);
    }
}
