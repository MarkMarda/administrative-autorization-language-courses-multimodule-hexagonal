package com.marda.administrative_authorization_language_courses_domain.authorization;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.evaluation.Evaluation;
import com.marda.administrative_authorization_language_courses_domain.evaluation.Observation;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.payment.Payment;
import com.marda.administrative_authorization_language_courses_domain.payment.PaymentStatus;
import com.marda.administrative_authorization_language_courses_domain.subsanation.Subsanation;

import java.time.Instant;
import java.util.*;

public final class AuthorizationRequest {
    private final Identity id;
    private final AuthorizationType type;
    private final Identity studentId;
    private final Identity courseId; // nullable depending on type
    private AuthorizationStatus status;
    private final Instant createdAt;
    private Instant updatedAt;

    private final Map<String, Requirement> requirements = new LinkedHashMap<>();
    private final List<Document> documents = new ArrayList<>();
    private final List<Payment> payments = new ArrayList<>();
    private final List<Evaluation> evaluations = new ArrayList<>();
    private final List<Observation> observations = new ArrayList<>();
    private final List<TrackingEntry> tracking = new ArrayList<>();
    private final List<Subsanation> subsanations = new ArrayList<>();

    public AuthorizationRequest(
            Identity id,
            AuthorizationType type,
            Identity studentId,
            Identity courseId,
            Collection<Requirement> requirements
    ) {
        this.id = Objects.requireNonNull(id);
        this.type = Objects.requireNonNull(type);
        this.studentId = Objects.requireNonNull(studentId);
        this.courseId = courseId;
        this.status = AuthorizationStatus.DRAFT;
        this.createdAt = Instant.now();
        this.updatedAt = createdAt;

        if (requirements != null) {
            for (Requirement r: requirements) this.requirements.put(r.getKey(), r);
        }
    }

    public void submit() throws DomainException {
        if (status != AuthorizationStatus.DRAFT) throw new DomainException("Only draft can be submitted");
        // Validate mandatory requirements present? (domain rule)
        this.status = AuthorizationStatus.SUBMITTED;
        addTracking(statusPrevious("DRAFT"), "SUBMITTED", null, "Solicitud enviada por el estudiante");
        touch();
    }

    public void addDocument(Document doc) {
        documents.add(Objects.requireNonNull(doc));
        touch();
    }

    public void registerPayment(Payment payment) {
        payments.add(Objects.requireNonNull(payment));
        // If payment completed automatically move forward? domain policy
        if (payment.status() == PaymentStatus.COMPLETED) {
            // example: nothing automatic here; evaluador decide
        }
        touch();
    }

    public void addEvaluation(Evaluation evaluation) {
        evaluations.add(Objects.requireNonNull(evaluation));
        switch (evaluation.getResult()) {
            case APPROVED -> this.status = AuthorizationStatus.APPROVED;
            case REJECTED -> this.status = AuthorizationStatus.REJECTED;
            case NEEDS_SUBSANATION -> this.status = AuthorizationStatus.NEEDS_SUBSANATION;
            default -> { this.status = AuthorizationStatus.IN_REVIEW; }
        }
        addTracking(statusPrevious(null), status.name(), evaluation.getEvaluatorId(), "Evaluación registrada: " + evaluation.getResult());
        touch();
    }

    public void requestSubsanation(Subsanation s) {
        subsanations.add(Objects.requireNonNull(s));
        this.status = AuthorizationStatus.NEEDS_SUBSANATION;
        addTracking(statusPrevious(null), status.name(), s.getStudentId(), "Subsanación solicitada");
        touch();
    }

    public void addObservation(Observation obs) {
        observations.add(Objects.requireNonNull(obs));
        touch();
    }

    private void addTracking(
            String from,
            String to,
            Identity actor,
            String note
    ) {
        tracking.add(new TrackingEntry(Identity.generate(), from, to, actor, Instant.now(), note));
    }

    private String statusPrevious(String fallback) {
        return fallback == null ? this.status.name() : fallback;
    }

    private void touch() {
        this.updatedAt = Instant.now();
    }

    public Identity getId() {
        return id;
    }

    public AuthorizationType getType() {
        return type;
    }

    public Identity getStudentId() {
        return studentId;
    }

    public Identity getCourseId() {
        return courseId;
    }

    public AuthorizationStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Map<String, Requirement> getRequirements() {
        return requirements;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public List<TrackingEntry> getTracking() {
        return tracking;
    }

    public List<Subsanation> getSubsanations() {
        return subsanations;
    }
}
