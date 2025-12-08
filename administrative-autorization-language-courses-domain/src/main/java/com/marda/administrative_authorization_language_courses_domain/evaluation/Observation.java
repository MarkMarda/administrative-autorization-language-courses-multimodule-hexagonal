package com.marda.administrative_authorization_language_courses_domain.evaluation;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;

import java.time.Instant;
import java.util.Objects;

public final class Observation {
    private final Identity id;
    private final Identity authorId;
    private final String text;
    private final Boolean visibleToStudent;
    private final Instant createdAt;

    public Observation(
            Identity id,
            Identity authorId,
            String text,
            Boolean visibleToStudent,
            Instant createdAt
    ) {
        this.id = Objects.requireNonNull(id);
        this.authorId = Objects.requireNonNull(authorId);
        this.text = Objects.requireNonNull(text);
        this.visibleToStudent = visibleToStudent;
        this.createdAt = Objects.requireNonNull(createdAt);
    }

    public Identity getId() {
        return id;
    }

    public Identity getAuthorId() {
        return authorId;
    }

    public String getText() {
        return text;
    }

    public Boolean getVisibleToStudent() {
        return visibleToStudent;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
