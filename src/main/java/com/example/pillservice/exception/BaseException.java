package com.example.pillservice.exception;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "Message not provided";
    private static final HttpStatus DEFAULT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    private String message;


    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return DEFAULT_HTTP_STATUS;
    }


    @Override
    public String getMessage() {
        return message == null ? DEFAULT_MESSAGE : message;
    }
}
