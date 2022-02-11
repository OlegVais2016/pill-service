package com.example.pillservice.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InputValidationException extends BaseException {

    private BindingResult bindingResult;

    public InputValidationException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public Map<String, List<String>> getValidationErrors() {
        return bindingResult.getFieldErrors()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                FieldError::getField,
                                Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage,
                                        Collectors.toList())
                        )
                );
    }
}
