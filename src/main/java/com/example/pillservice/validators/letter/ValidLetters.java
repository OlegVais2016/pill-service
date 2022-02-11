package com.example.pillservice.validators.letter;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidLettersAnnotationConstraint.class)
@Documented
public @interface ValidLetters {

    String message() default "Must contain only english alphabet symbols";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
