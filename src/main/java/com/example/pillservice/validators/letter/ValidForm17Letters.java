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
@Constraint(validatedBy = ValidForm17LettersAnnotationConstraint.class)
@Documented
public @interface ValidForm17Letters {

    String message() default "must contains only english alphabet symbols";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    boolean english() default false;
    boolean russian() default false;
    boolean hebrew() default false;
}
