package com.pragma.arquetipobootcamp2024.configuration;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "The element indicated does not exist";
    public static final String TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The technology you want to create already exists";
    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "Field %s can not be empty";
    public static final String NEGATIVE_NOT_ALLOWED_EXCEPTION_MESSAGE = "Field %s can not receive negative values";
    public static final String DESCRIPTION_NOT_FOUND_EXCEPTION_MESSAGE = "Description cannot be null";
    public static final String NAME_LENGTH_EXCEED_EXCEPTION_MESSAGE = "Name cannot have more than 50 characters";
    public static final String DESCRIPTION_LENGTH_EXCEED_EXCEPTION_MESSAGE = "Description cannot have more than 90 characters";

}
