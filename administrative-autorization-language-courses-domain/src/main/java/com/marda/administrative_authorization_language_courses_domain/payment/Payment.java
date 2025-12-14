package com.marda.administrative_authorization_language_courses_domain.payment;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;

import java.time.Instant;
import java.util.Objects;

public record Payment(
        Identity id,
        Money amount,
        String provider,
        String providerTransactionId,
        PaymentStatus status,
        Instant createdAt
) {
    public Payment {
        Objects.requireNonNull(id);
        Objects.requireNonNull(amount);
        Objects.requireNonNull(provider);
        Objects.requireNonNull(status);
        Objects.requireNonNull(createdAt);
    }
}
