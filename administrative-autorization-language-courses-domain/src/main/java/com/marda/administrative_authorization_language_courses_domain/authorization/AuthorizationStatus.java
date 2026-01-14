package com.marda.administrative_authorization_language_courses_domain.authorization;

public enum AuthorizationStatus {
    DRAFT,
    SUBMITTED,
    IN_REVIEW,
    NEEDS_SUBSANATION,
    APPROVED,
    REJECTED,
    CLOSED, // When for period someone cancel
    CANCELLED // When person interested cancel
}
