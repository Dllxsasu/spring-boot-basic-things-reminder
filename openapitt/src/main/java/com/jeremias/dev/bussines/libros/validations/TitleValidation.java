package com.jeremias.dev.bussines.libros.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( {  ElementType.FIELD })
@Constraint(validatedBy = TitleExistValidator.class)
public @interface TitleValidation {
    String message() default "Title is alredy registered, please insert a new title";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
