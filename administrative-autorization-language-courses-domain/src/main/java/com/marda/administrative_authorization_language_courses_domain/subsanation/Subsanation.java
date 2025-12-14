package com.marda.administrative_authorization_language_courses_domain.subsanation;

import com.marda.administrative_authorization_language_courses_domain.authorization.Document;
import com.marda.administrative_authorization_language_courses_domain.base.Identity;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

public final class Subsanation {
    private final Identity id;
    private final Identity requirementId;
    private final Identity studentId;
    private final List<Document> submittedDocuments;
    private final String comment;
    private final Instant submittedAt;
    private final SubsanationStatus status;

    public Subsanation(
            Identity id,
            Identity requirementId,
            Identity studentId,
            List<Document> submittedDocuments,
            String comment,
            Instant submittedAt,
            SubsanationStatus status
    ) {
        this.id = Objects.requireNonNull(id);
        this.requirementId = Objects.requireNonNull(requirementId);
        this.studentId = Objects.requireNonNull(studentId);
        this.submittedDocuments = Objects.requireNonNull(submittedDocuments);
        this.comment = comment;
        this.submittedAt = Objects.requireNonNull(submittedAt);
        this.status = Objects.requireNonNull(status);
    }

    public Identity getId() {
        return id;
    }

    public Identity getRequirementId() {
        return requirementId;
    }

    public Identity getStudentId() {
        return studentId;
    }

    public List<Document> getSubmittedDocuments() {
        return submittedDocuments;
    }

    public String getComment() {
        return comment;
    }

    public Instant getSubmittedAt() {
        return submittedAt;
    }

    public SubsanationStatus getStatus() {
        return status;
    }
}
