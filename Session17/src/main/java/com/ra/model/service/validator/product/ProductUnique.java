package com.ra.model.service.validator.product;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProductCheckName.class)
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductUnique {
    String message() default "Product name existed ";
    Class<?> [] groups() default {} ;
    Class<? extends Payload> [] payload() default {} ;
}
