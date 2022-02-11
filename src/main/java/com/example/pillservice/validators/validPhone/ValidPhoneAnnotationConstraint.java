package com.example.pillservice.validators.validPhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidPhoneAnnotationConstraint implements ConstraintValidator<ValidPhone, String> {

    private static final String NUMBERS = "\\d{10}";

    @Override
    public void initialize(ValidPhone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {

        if (phone == null) {
            return true;
        }
        return phone.matches(NUMBERS);
    }
}
