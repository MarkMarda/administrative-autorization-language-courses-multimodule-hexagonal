package com.marda.administrative_authorization_language_courses_domain.authorization;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;

import java.time.Instant;
import java.util.Objects;

public record Document(
        Identity id,
        String filename,
        String storageRef,
        String checksum,
        Instant uploadedAt
) {
    public Document {
        Objects.requireNonNull(id);
        Objects.requireNonNull(filename);
        Objects.requireNonNull(storageRef);
        Objects.requireNonNull(checksum);
        Objects.requireNonNull(uploadedAt);
    }
}
