package com.marda.administrative_authorization_language_courses_domain.person;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;

import java.time.LocalDate;
import java.util.Objects;

public class StudenCandidat extends Person {
    private final Email email;
    private final String phoneNumber;

    public StudenCandidat(
            Identity id,
            String firstName,
            String middleName,
            String firstSurname,
            String secondSurname,
            LocalDate birthDate,
            Email email,
            String phoneNumber
    ) throws DomainException {
        super(id, firstName, middleName, firstSurname, secondSurname, birthDate);
        this.email = email;
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    public Email getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
