package com.example.pillservice.validators.letter;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidLettersAnnotationConstraint
        implements ConstraintValidator<ValidLetters, String> {

    private static final String LETTERS = "^[a-zA-Z]+";

    @Override
    public void initialize(ValidLetters constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return value.matches(LETTERS);
    }
}
