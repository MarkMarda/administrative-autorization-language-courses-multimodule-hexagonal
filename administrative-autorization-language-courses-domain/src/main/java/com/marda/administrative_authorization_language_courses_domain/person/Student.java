package com.marda.administrative_authorization_language_courses_domain.person;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private final Long idCredential;
    private final List<String> enrolledLanguageCourses;
    private final String phoneNumber;
    private final Email email;

    public Student(
            Identity id,
            String firstName,
            String middleName,
            String firstSurname,
            String secondSurname,
            LocalDate birthDate,
            Long idCredential,
            List<String> enrolledLanguageCourses,
            String phoneNumber,
            Email email
    ) throws DomainException {
        super(id, firstName, middleName, firstSurname, secondSurname, birthDate);
        this.idCredential = Objects.requireNonNull(idCredential);
        this.enrolledLanguageCourses = new ArrayList<>(enrolledLanguageCourses);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.email = email;
    }

    public Long getIdCredential() {
        return idCredential;
    }

    public List<String> getEnrolledLanguageCourses() {
        return Collections.unmodifiableList(enrolledLanguageCourses);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Email getEmail() {
        return email;
    }
}
