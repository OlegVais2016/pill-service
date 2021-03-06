package com.example.pillservice.validators.validPhone;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidPhoneAnnotationConstraint.class)
@Documented
public @interface ValidPhone {

    String message() default "Phone number must contain 10 digits";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
