package com.example.pillservice.validators.nationalID;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NationalIdChecksumAnnotationConstraint implements ConstraintValidator<NationalIdChecksum, String> {

    @Override
    public void initialize(NationalIdChecksum constraintAnnotation) {
    }

    @Override
    public boolean isValid(String nationalId, ConstraintValidatorContext constraintValidatorContext) {

        if (nationalId == null)
            return true;

        if (nationalId.isEmpty())
            return true;

        if (nationalId.length() < 5)
            return false;

        if (!nationalId.chars().allMatch(Character::isDigit))
            return false;

        String idWithoutChecksum = nationalId.substring(0,nationalId.length()-1);
        String checksum = nationalId.substring(nationalId.length()-1);

        int sum = 0;

        for (int i = 0; i < idWithoutChecksum.length(); i++) {
            char ch = idWithoutChecksum
                    .charAt(idWithoutChecksum.length() - i - 1);
            int digit = (int) ch - 48;
            int weight;
            if (i % 2 == 0) {
                weight = 2 * digit -  digit / 5 * 9;
            } else {
                weight = digit;
            }

            sum += weight;
        }

        int checksumCalculated = (10 - (sum % 10)) % 10;

        return Integer.valueOf(checksum) == checksumCalculated;

    }
}
