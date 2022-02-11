package com.example.pillservice.validators.dateOfBirth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ValidDateOfBirthAnnotationConstraint implements ConstraintValidator<ValidDateOfBirth,String> {


    @Override
    public void initialize(ValidDateOfBirth constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }


        try {
            LocalDate localDate = LocalDate.parse(value);

            return !localDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
