package com.example.pillservice.validators.image;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidImageSizeAnnotationConstraint implements ConstraintValidator<ValidImageSize, String> {

    private int valueForCalculate;
    private int maxSizeFile;
    private final int INCREASE_SIZE_BASE64 = 137;

    @Override
    public void initialize(ValidImageSize constraintAnnotation) {
        this.maxSizeFile = constraintAnnotation.maxSize();
        this.valueForCalculate = constraintAnnotation.imageMeasure().getSize();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if (s == null) {
            return true;
        }

        int sizeImage = s.getBytes().length / valueForCalculate;


        if (maxSizeFile > (sizeImage/100)* INCREASE_SIZE_BASE64) {
            return true;
        }

        return false;
    }
}
