package com.marda.administrative_authorization_language_courses_domain.person;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;

import java.util.Objects;

public class Teacher extends Person{
    private final Email email;
    private final String dni;
    private final String professionalLicence;
    private final String phoneNumber;

    public Teacher(
            Identity id,
            String firstName,
            String middleName,
            String firstSurname,
            String secondSurname,
            String birthDate,
            Email email,
            String dni,
            String professionalLicence, String phoneNumber
    ) throws DomainException {
        super(id, firstName, middleName, firstSurname, secondSurname, birthDate);
        this.email = email;
        this.dni = Objects.requireNonNull(dni);
        this.professionalLicence = Objects.requireNonNull(professionalLicence);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    public Email getEmail() {
        return email;
    }

    public String getDni() {
        return dni;
    }

    public String getProfessionalLicence() {
        return professionalLicence;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
