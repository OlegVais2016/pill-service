package com.example.pillservice.validators.dateOfBirth;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidDateOfBirthAnnotationConstraint.class)
@Documented
public @interface ValidDateOfBirth {

    String message() default "Incorrect date format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
