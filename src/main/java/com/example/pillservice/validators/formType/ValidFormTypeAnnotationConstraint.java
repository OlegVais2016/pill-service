package com.example.pillservice.validators.formType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidFormTypeAnnotationConstraint implements ConstraintValidator<ValidFormType, String> {

    private static final String FORM_TYPE = "^[1-5]$";

    @Override
    public void initialize(ValidFormType constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value == null){
            return true;
        }
        return value.matches(FORM_TYPE);
    }
}
