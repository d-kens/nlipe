package com.peid.api.common.exception;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException() {
        super("Email already exist");
    }
}