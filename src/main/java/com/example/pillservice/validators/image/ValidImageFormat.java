package com.example.pillservice.validators.image;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy =
        ValidImageFormatAnnotationConstraint.class)
@Documented
public @interface ValidImageFormat {

    String message() default "File format is not supported";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    ImageFormats[] format() default ImageFormats.JPG;

}
