package com.pragma.arquetipobootcamp2024.domain.model;

import com.pragma.arquetipobootcamp2024.domain.exception.DescriptionFieldExceedException;
import com.pragma.arquetipobootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.arquetipobootcamp2024.domain.exception.FieldLengthExceededException;
import com.pragma.arquetipobootcamp2024.domain.exception.NegativeNotAllowedException;
import com.pragma.arquetipobootcamp2024.domain.util.DomainConstants;

import java.math.BigDecimal;

import static java.util.Objects.requireNonNull;

public class Technology {
    private final Long id;
    private final String name;
    private final String description;

    public Technology(long id, String name, String description) {
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.NAME.toString());
        }
        if (name.length() > 50) {
            throw new FieldLengthExceededException(DomainConstants.Field.NAMELENGTH.toString(), 50);
        }
        if (description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstants.Field.DESCRIPTIONLENGTH.toString());
        }
        if (description.length() > 90) {
            throw new DescriptionFieldExceedException(DomainConstants.Field.DESCRIPTION.toString(), 90);
        }
        this.id = id;
        this.name = requireNonNull(name, DomainConstants.FIELD_NAME_NULL_MESSAGE);
        this.description = requireNonNull(description, DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
