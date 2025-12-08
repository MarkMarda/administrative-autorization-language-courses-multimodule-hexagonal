package com.marda.administrative_authorization_language_courses_domain.authorization;

import java.util.Objects;

public class Requirement {
    private final String key;
    private final String description;
    private final Boolean mandatory;


    public Requirement(String key, String description, Boolean mandatory) {
        this.key = Objects.requireNonNull(key);
        this.description = Objects.requireNonNull(description);
        this.mandatory = mandatory;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getMandatory() {
        return mandatory;
    }
}
