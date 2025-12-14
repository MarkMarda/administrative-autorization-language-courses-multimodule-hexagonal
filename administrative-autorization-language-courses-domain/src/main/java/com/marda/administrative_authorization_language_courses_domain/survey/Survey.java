package com.marda.administrative_authorization_language_courses_domain.survey;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;

import java.time.Instant;
import java.util.Map;
import java.util.Objects;

public final class Survey {
    private final Identity id;
    private final Identity authorizationRequestId;
    private final Map<String, String> answers; // questionId -> answer
    private final Integer score; // optional aggregated score
    private final Instant submittedAt;

    public Survey(
            Identity id,
            Identity authorizationRequestId,
            Map<String, String> answers,
            Integer score,
            Instant submittedAt
    ) {
        this.id = Objects.requireNonNull(id);
        this.authorizationRequestId = Objects.requireNonNull(authorizationRequestId);
        this.answers = Objects.requireNonNull(answers);
        this.score = score;
        this.submittedAt = Objects.requireNonNull(submittedAt);
    }

    public Identity getId() {
        return id;
    }

    public Identity getAuthorizationRequestId() {
        return authorizationRequestId;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public Integer getScore() {
        return score;
    }

    public Instant getSubmittedAt() {
        return submittedAt;
    }
}
