package com.hyejun0608.BookstoreInMemoryBE.exception;

public class UserNotFoundException extends ExceptionHandler {

    public static final UserNotFoundException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(404, "User is not found.");
    }
}
