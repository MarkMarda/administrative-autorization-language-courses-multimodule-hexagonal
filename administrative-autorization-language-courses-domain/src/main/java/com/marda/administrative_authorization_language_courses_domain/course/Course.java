package com.marda.administrative_authorization_language_courses_domain.course;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;

import java.util.Objects;

public class Course {
    private final Identity id;
    private final String code;   // e.g., B2-2025-ENG
    private final String name;   // e.g., Inglés B2
    private final String level;

    public Course(Identity id, String code, String name, String level) throws DomainException {
        this.id = Objects.requireNonNull(id);
        this.code = Objects.requireNonNull(code);
        this.name = Objects.requireNonNull(name);
        this.level = Objects.requireNonNull(level);
    }

    public Identity getId() {
        return id;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
