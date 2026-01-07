package com.marda.administrative_authorization_language_courses_domain.person;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;

import java.time.LocalDate;
import java.util.Objects;

public class AdministrativeCoordinator extends Person {
    private final Email email;
    private final String phoneNumber;

    public AdministrativeCoordinator(
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
}
