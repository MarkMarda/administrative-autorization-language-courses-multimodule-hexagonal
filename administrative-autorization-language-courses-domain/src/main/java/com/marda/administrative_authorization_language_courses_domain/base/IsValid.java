package com.marda.administrative_authorization_language_courses_domain.base;

import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;

@FunctionalInterface
public interface IsValid {
    void valid() throws DomainException;
}
