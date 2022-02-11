package com.example.pillservice.exception;

import org.springframework.http.HttpStatus;

public class HcAuthenticationException extends BaseException {

    private static final String MESSAGE = "Re-login required to your health care";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.PRECONDITION_FAILED;
    }

}
