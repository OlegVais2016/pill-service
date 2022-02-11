package com.example.pillservice.validators.image;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.ps.core.validators.image.ImageMeasureSize.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidImageSizeAnnotationConstraint.class)
@Documented
public @interface ValidImageSize {

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int maxSize() default 100;

    ImageMeasureSize imageMeasure() default KILOBYTE;

    String message() default "Image size cannot exceed 100 Kb";
}