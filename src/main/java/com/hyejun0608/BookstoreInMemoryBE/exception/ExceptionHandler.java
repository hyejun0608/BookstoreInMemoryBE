package com.hyejun0608.BookstoreInMemoryBE.exception;

import lombok.Getter;

@Getter
public class ExceptionHandler extends RuntimeException{

    private final int status;
    private final String message;

    protected ExceptionHandler(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
