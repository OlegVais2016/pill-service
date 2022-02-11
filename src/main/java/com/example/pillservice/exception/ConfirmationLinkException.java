package com.example.pillservice.exception;

public class ConfirmationLinkException extends BaseException {
    @Override
    public String getMessage() {
        return "Resource not found";
    }
}
