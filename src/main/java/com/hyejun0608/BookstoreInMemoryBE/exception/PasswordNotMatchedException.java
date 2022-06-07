package com.hyejun0608.BookstoreInMemoryBE.exception;

public class PasswordNotMatchedException extends ExceptionHandler {

    public static final PasswordNotMatchedException EXCEPTION = new PasswordNotMatchedException();

    private PasswordNotMatchedException() {
        super(400, "Password is not matched.");
    }
}
