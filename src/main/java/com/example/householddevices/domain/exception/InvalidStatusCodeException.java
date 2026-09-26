package com.example.householddevices.domain.exception;

public class InvalidStatusCodeException extends RuntimeException{

    public InvalidStatusCodeException(String message) {
        super(message);
    }

}