package com.example.springbootonline2.exception;

public class UnprocessableException extends RuntimeException{
    public UnprocessableException(String message) {
        super(message);
    }
}
