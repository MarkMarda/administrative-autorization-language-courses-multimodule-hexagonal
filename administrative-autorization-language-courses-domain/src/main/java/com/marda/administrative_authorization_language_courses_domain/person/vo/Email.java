package com.marda.administrative_authorization_language_courses_domain.person.vo;

import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;

import java.util.Objects;

public class Email {
    private final String value;

    // OWASP Validation Regular Expression
    // https://www.baeldung.com/java-email-validation-regex
    private static final String REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final String EMAIL_REQUIRED = "Email required";
    private static final String EMAIL_NOT_VALID = "Email is not valid";

    private Email(String value) {
        this.value = value;
    }

    public static Email create(String value) throws DomainException {
        if (value == null || value.isBlank()) {
            throw new DomainException(EMAIL_REQUIRED);
        }

        if (!value.matches(REGEX)) {
            throw new DomainException(EMAIL_NOT_VALID);
        }

        return new Email(value);
    }

    /**
     * Factory used when reconstructing domain objects
     * from persisted state (e.g., database records).
     *
     * Throws IllegalStateException if persisted data is invalid.
     */
    public static Email fromDb(String value) {
        try {
            return create(value);
        } catch (DomainException e) {
            throw new IllegalStateException("Invalid email in DB", e);
        }
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }

}
