package com.marda.administrative_authorization_language_courses_domain.base;

import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;

public class GenericDomain implements IsValid {
    protected Long id;

    public GenericDomain(Long id) throws DomainException {
        isValidId(id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void valid() throws DomainException {
    }

    protected void isValidId(Long id) throws DomainException {
        if (id == null || id <= 0) {
            throw new DomainException(String.format("Id = %d is not valid", id));
        }
    }
}
