package com.hyejun0608.BookstoreInMemoryBE.exception;

public class UserNotAccessibleException extends ExceptionHandler {

    public static final UserNotAccessibleException EXCEPTION = new UserNotAccessibleException();

    private UserNotAccessibleException() {
        super(401, "User is not accessible.");
    }
}
