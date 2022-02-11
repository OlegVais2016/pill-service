package com.example.pillservice.exception;

import org.springframework.http.HttpStatus;

public class HcCommonException extends BaseException {

    private static final String MESSAGE = "Unexpected error occurred during Health Care communication session";

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
