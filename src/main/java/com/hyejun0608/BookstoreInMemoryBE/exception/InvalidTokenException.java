package com.hyejun0608.BookstoreInMemoryBE.exception;

public class InvalidTokenException extends ExceptionHandler {

    public static final InvalidTokenException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(401, "This token is invalid.");
    }
}
