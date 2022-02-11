package com.example.pillservice.validators.sizeListImage;



import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ValidSizeListImageAnnotationConstraint
        implements ConstraintValidator<ValidSizeListImage,List<String>> {

    private String[] content;
    private Integer maxSize;

    @Override
    public void initialize(ValidSizeListImage constraintAnnotation) {
        this.content = constraintAnnotation.content();
        this.maxSize = constraintAnnotation.maxsize();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }
        if(value.size() > maxSize){
            return false;
        }
        return true;
    }
}
