package com.marda.administrative_authorization_language_courses_domain.authorization;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;

import java.time.Instant;
import java.util.Objects;

public final class TrackingEntry {
    private final Identity id;
    private final String fromState;
    private final String toState;
    private final Identity actorId;
    private final Instant createdAt;
    private final String note;

    public TrackingEntry(
            Identity id,
            String fromState,
            String toState,
            Identity actorId,
            Instant createdAt,
            String note
    ) {
        this.id = Objects.requireNonNull(id);
        this.fromState = Objects.requireNonNull(fromState);
        this.toState = Objects.requireNonNull(toState);
        this.actorId = actorId;
        this.createdAt = Objects.requireNonNull(createdAt);
        this.note = note;
    }

    public Identity getId() {
        return id;
    }

    public String getFromState() {
        return fromState;
    }

    public String getToState() {
        return toState;
    }

    public Identity getActorId() {
        return actorId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getNote() {
        return note;
    }
}
