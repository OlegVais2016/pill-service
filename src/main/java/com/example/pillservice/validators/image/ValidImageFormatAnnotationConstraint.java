package com.example.pillservice.validators.image;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Base64;

public class ValidImageFormatAnnotationConstraint implements ConstraintValidator<ValidImageFormat, String> {

    private static final String DELIMITERS = ",";
    private static final int COUNT_INFO_DATA_IN_STRING_IMAGE = 2;

    private ImageFormats[] receivedImageFormats;


    @Override
    public void initialize(ValidImageFormat constraintAnnotation) {
        this.receivedImageFormats = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String stringImage, ConstraintValidatorContext constraintValidatorContext) {

        if (stringImage == null) {
            return true;
        }

        byte[] decodedBytes = convertStringToByteArray(stringImage);
        byte[] firstTwoBytes = new byte[COUNT_INFO_DATA_IN_STRING_IMAGE];

        for (int i = 0; i < COUNT_INFO_DATA_IN_STRING_IMAGE; i++) {
            firstTwoBytes[i]=decodedBytes[i];
        }

        boolean flag = false;

        for ( ImageFormats iFormat: receivedImageFormats) {
            if(Arrays.equals(iFormat.getFormat(), firstTwoBytes)){
                flag = true;
            }
        }

        return flag;

    }


    private byte[] convertStringToByteArray(String stringImage) {

        String[] splitImageString = stringImage.split(DELIMITERS);

        byte[] decodedBytes;

        if (splitImageString.length == 2) {
            decodedBytes = Base64.getDecoder().decode(splitImageString[1]);
        } else {
            decodedBytes = Base64.getDecoder().decode(splitImageString[0]);
        }
        return decodedBytes;
    }
}
