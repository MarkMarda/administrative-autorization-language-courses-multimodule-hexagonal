package com.marda.administrative_authorization_language_courses_domain.person;

import com.marda.administrative_authorization_language_courses_domain.base.GenericDomain;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;

public class Person extends GenericDomain {
    protected String name;
    protected String lastName;
    protected String middleName;
    protected String birthday;

    public Person(Long id, String name, String lastName, String middleName) throws DomainException {
        super(id);
        this.name = name;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getBirthday() {
        return birthday;
    }
}
