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
@Constraint(validatedBy = NationalIdChecksumAnnotationConstraint.class)
@Documented

public @interface NationalIdChecksum {

    String message() default "incorrect security number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
