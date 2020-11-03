package com.thoughtworks.capacity.gtb.mvc.exception;

public class NameRepeatException extends RuntimeException {
    public NameRepeatException(String message) {
        super(message);
    }
}
