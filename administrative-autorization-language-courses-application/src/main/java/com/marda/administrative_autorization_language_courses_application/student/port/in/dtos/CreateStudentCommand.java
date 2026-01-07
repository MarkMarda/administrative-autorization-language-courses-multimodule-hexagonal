package com.marda.administrative_autorization_language_courses_application.student.port.in.dtos;

import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;
import com.marda.administrative_autorization_language_courses_application.student.exception.StudentApplicationException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public record CreateStudentCommand(
        String firstName,
        String middleName,
        String firstSurname,
        String secondSurname,
        LocalDate birthDate,
        Long idCredential,
        List<String> enrolledLanguageCourses,
        String phoneNumber,
        Email email
) {
    private static final String MESSAGE_NOT_BLANK = "must not be blank";
    private static final String MANDATORY_FIRST_NAME = "firstName";
    private static final String MANDATORY_FIRST_SURNAME = "firstSurname";
    private static final String MANDATORY_BIRTH_DATE = "birthDate";
    private static final String MANDATORY_PHONE_NUMBER = "phoneNumber";
    private static final String MANDATORY_ID_CREDENTIAL = "idCredential";
    private static final String MANDATORY_ENROLLED_COURSE = "enrolledLanguageCourses";
    private static final String MANDATORY_EMAIL = "email";

    public CreateStudentCommand {
        try {
            enrolledLanguageCourses = List.copyOf(enrolledLanguageCourses);

            requireNotBlank(firstName, MANDATORY_FIRST_NAME);
            requireNotBlank(firstSurname, MANDATORY_FIRST_SURNAME);
            Objects.requireNonNull(birthDate, MANDATORY_BIRTH_DATE);
            requireNotBlank(phoneNumber, MANDATORY_PHONE_NUMBER);
            Objects.requireNonNull(idCredential, MANDATORY_ID_CREDENTIAL);
            Objects.requireNonNull(enrolledLanguageCourses, MANDATORY_ENROLLED_COURSE);
            Objects.requireNonNull(email, MANDATORY_EMAIL);
        } catch (StudentApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    private static void requireNotBlank(String value, String field) throws StudentApplicationException {
        if (value == null || value.isBlank()) {
            throw new StudentApplicationException(field + " " + MESSAGE_NOT_BLANK);
        }
    }
}
