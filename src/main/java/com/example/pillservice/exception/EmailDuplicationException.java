package com.example.pillservice.exception;

import org.springframework.http.HttpStatus;

public class EmailDuplicationException extends BaseException {


    @Override
    public HttpStatus getHttpStatus() { return HttpStatus.CONFLICT; }

    @Override
    public String getMessage() {
        return "User with such email already exists";
    }



}
