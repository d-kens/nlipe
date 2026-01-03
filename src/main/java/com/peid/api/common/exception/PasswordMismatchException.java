package com.peid.api.common.exception;

public class PasswordMismatchException extends RuntimeException {
    public PasswordMismatchException() {
        super("passwords do not match");
    }
}
