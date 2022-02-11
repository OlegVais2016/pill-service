package com.example.pillservice.validators.validPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidPasswordAnnotationConstraint implements ConstraintValidator<ValidPassword, String> {

    private static final String UPPER_CASE_CHARS = "(.*[A-Z].*)";
    private static final String LOWER_CASE_CHARS = "(.*[a-z].*)";
    private static final String NUMBERS = "(.*[0-9].*)";
    private static final String SPECIAL_CHARS = "(.*[.,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";

    private boolean upperCaseLetters;
    private boolean lowerCaseLetters;
    private boolean specialCharacters;
    private boolean numbers;

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        this.upperCaseLetters = constraintAnnotation.upperCaseLetters();
        this.lowerCaseLetters = constraintAnnotation.lowerCaseLetters();
        this.specialCharacters = constraintAnnotation.specialCharacters();
        this.numbers = constraintAnnotation.numbers();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        if (password == null) {
            return true;
        }

        if (upperCaseLetters && !password.matches(UPPER_CASE_CHARS)) {
            return false;
        }

        if (lowerCaseLetters && !password.matches(LOWER_CASE_CHARS)) {
            return false;
        }


        if (specialCharacters && !password.matches(SPECIAL_CHARS)) {
            return false;
        }

        if (numbers && !password.matches(NUMBERS)) {
            return false;
        }

        return true;
    }
}
