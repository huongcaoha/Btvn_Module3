package com.ra.model.service.validator.category;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckCategoryUnique.class)
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoryUnique {
    String message() default "Category existed !" ;
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {} ;
}
