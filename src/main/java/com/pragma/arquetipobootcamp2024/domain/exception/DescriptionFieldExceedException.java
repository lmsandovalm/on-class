package com.pragma.arquetipobootcamp2024.domain.exception;

public class DescriptionFieldExceedException extends RuntimeException {

    public DescriptionFieldExceedException(String fieldName, int maxLength) {
        super("Length of field '" + fieldName + "' exceeds maximum allowed length of " + maxLength + " characters");
    }
}

