package org.kizombadev.spring.demo.exception;

public class NotFoundException extends RuntimeException {

    protected NotFoundException(String message) {
        super(message);
    }

    public static NotFoundException create(String id) {
        return new NotFoundException(String.format("The object with the id '%s' was not found", id));
    }
}
