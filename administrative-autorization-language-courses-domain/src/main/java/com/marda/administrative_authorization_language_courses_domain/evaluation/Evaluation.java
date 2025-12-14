package com.marda.administrative_authorization_language_courses_domain.evaluation;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;

import java.time.Instant;
import java.util.Objects;

public final class Evaluation {
    private final Identity id;
    private final Identity evaluatorId;
    private final EvaluationResult result;
    private final String comments;
    private final Instant createdAt;

    public Evaluation(
            Identity id,
            Identity evaluatorId,
            EvaluationResult result,
            String comments,
            Instant createdAt
    ) {
        this.id = Objects.requireNonNull(id);
        this.evaluatorId = Objects.requireNonNull(evaluatorId);
        this.result = Objects.requireNonNull(result);
        this.comments = comments;
        this.createdAt = Objects.requireNonNull(createdAt);
    }

    public Identity getId() {
        return id;
    }

    public Identity getEvaluatorId() {
        return evaluatorId;
    }

    public EvaluationResult getResult() {
        return result;
    }

    public String getComments() {
        return comments;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
