package com.hyejun0608.BookstoreInMemoryBE.exception;

public class UserNotAuthenticatedException extends ExceptionHandler {

    public static final UserNotAuthenticatedException EXCEPTION = new UserNotAuthenticatedException();

    private UserNotAuthenticatedException() {
        super(401, "User is not Authenticated");
    }

}
