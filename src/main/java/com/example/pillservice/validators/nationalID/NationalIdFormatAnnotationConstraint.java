package com.example.pillservice.validators.nationalID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NationalIdFormatAnnotationConstraint implements ConstraintValidator<NationalIdFormat,String> {

    @Override
    public void initialize(NationalIdFormat constraintAnnotation) {
    }

    @Override
    public boolean isValid(String nationalId, ConstraintValidatorContext constraintValidatorContext) {

        if (nationalId == null)
            return true;

        if (nationalId.isEmpty())
            return true;

        return nationalId.chars().allMatch(Character::isDigit);
    }
}
