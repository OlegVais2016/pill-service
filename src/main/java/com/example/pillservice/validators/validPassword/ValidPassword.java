package com.example.pillservice.validators.validPassword;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPasswordAnnotationConstraint.class)
@Documented
public @interface ValidPassword {

    String message() default "Incorrect password format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean upperCaseLetters() default false;
    boolean lowerCaseLetters() default false;
    boolean specialCharacters() default false;
    boolean numbers() default false;

}
