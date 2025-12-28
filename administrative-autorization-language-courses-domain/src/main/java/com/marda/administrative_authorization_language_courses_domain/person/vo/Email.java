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

    public String getValue() {
        return value;
    }

}
