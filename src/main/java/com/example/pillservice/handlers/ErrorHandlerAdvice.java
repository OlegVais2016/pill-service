package com.example.pillservice.handlers;

import com.ps.core.exception.BaseException;
import com.ps.core.exception.InputValidationException;
import com.ps.core.model.web.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerAdvice {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> getBaseResponse(BaseException e) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, e.getHttpStatus());
    }

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<ErrorResponse> getInputValidationError(InputValidationException e) {

        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .data(e.getValidationErrors())
                .build();


        return new ResponseEntity<>(errorResponse, e.getHttpStatus());
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> getBaseResponse(Exception e) {
        ErrorResponse errorResponse = ErrorResponse
                .builder()
                .message(e.getMessage())
                .build();


        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
