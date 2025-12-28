package com.marda.administrative_authorization_language_courses_domain.person;

import com.marda.administrative_authorization_language_courses_domain.base.GenericDomain;
import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;

import java.util.Objects;

public class Person {
    private final Identity id;
    private final String firstName;
    private final String middleName;
    private final String firstSurname;
    private final String secondSurname;
    private final String birthDate;

    private static final String MESSAGE_NOT_BLANK = "must not be blank";
    private static final String MANDATORY_FIRST_NAME = "firstName";
    private static final String MANDATORY_FIRST_SURNAME = "firstSurname";

    public Person(
            Identity id,
            String firstName,
            String middleName,
            String firstSurname,
            String secondSurname,
            String birthDate
    ) throws DomainException {
        this.id = Objects.requireNonNull(id);
        this.firstName = requireNotBlank(firstName, MANDATORY_FIRST_NAME);
        this.middleName = middleName;
        this.firstSurname = requireNotBlank(firstSurname, MANDATORY_FIRST_SURNAME);
        this.secondSurname = secondSurname;
        this.birthDate = Objects.requireNonNull(birthDate);
    }

    protected String requireNotBlank(String value, String field) throws DomainException {
        if (value == null || value.isBlank()) {
            throw new DomainException(field + " " + MESSAGE_NOT_BLANK);
        }

        return value;
    }

    public Identity getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
