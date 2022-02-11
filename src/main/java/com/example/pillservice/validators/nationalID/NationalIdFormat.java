package com.example.pillservice.validators.nationalID;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NationalIdFormatAnnotationConstraint.class)
@Documented

public @interface NationalIdFormat {

        String message() default "NationalID format is incorrect";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
}
