package com.example.pillservice.validators.sizeListImage;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidSizeListImageAnnotationConstraint.class)
@Documented
public @interface ValidSizeListImage {

    String message() default "Maximum number images is 3";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] content() default {};

    int maxsize() default 3;
}
