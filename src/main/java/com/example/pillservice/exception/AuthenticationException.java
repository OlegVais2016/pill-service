package com.example.pillservice.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor

public class AuthenticationException extends BaseException {


    private static final String MESSAGE = "Authentication error. Login or password is wrong";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.UNAUTHORIZED;
    }


}


