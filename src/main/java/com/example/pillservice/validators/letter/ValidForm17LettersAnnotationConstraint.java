package com.example.pillservice.validators.letter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidForm17LettersAnnotationConstraint
        implements ConstraintValidator<ValidForm17Letters, String> {

    private static final String ENGLISH_LETTERS = "^[a-zA-Z\\s]+$";
    private static final String RUSSIAN_LETTERS = "^[а-яА-Я\\s]+$";
    private static final String HEBREW_LETTERS = "^[\\u0590-\\u05FF\\s]+$";
    private boolean english;
    private boolean russian;
    private boolean hebrew;

    @Override
    public void initialize(ValidForm17Letters constraintAnnotation) {
        this.english = constraintAnnotation.english();
        this.russian = constraintAnnotation.russian();
        this.hebrew = constraintAnnotation.hebrew();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value == null){
            return true;
        }
        if ((english || !value.matches(ENGLISH_LETTERS))
                && (russian || !value.matches(RUSSIAN_LETTERS))
                && (hebrew || !value.matches(HEBREW_LETTERS))) {
            return false;
        }

        return true;
    }
}
