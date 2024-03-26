package com.pragma.arquetipobootcamp2024.domain.util;

public final class DomainConstants {
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        DESCRIPTION,
        NAMELENGTH,
        DESCRIPTIONLENGTH
    }

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'quantity' cannot be null";
    public static final String FIELD_NAME_LENGTH_NULL_MESSAGE = "Field 'name' cannot be over 50 characters";

}
