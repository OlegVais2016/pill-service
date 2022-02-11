package com.example.pillservice.exception;


import org.springframework.http.HttpStatus;


public class NotFoundException extends BaseException{

    private  String MESSAGE;

    public NotFoundException(String s) {
        this.MESSAGE = s;
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
