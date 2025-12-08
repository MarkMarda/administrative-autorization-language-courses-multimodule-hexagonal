package com.marda.administrative_authorization_language_courses_domain.person;

import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;

public class Student extends Person {
    protected Long idCredential;
    protected String[] languageCourses;


    public Student(Long id, String name, String lastName, String middleName) throws DomainException {
        super(id, name, lastName, middleName);
    }
}
