package com.marda.administrative_authorization_language_courses_domain.payment;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(
        BigDecimal amount,
        String currency
) {
    public Money {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(currency);
        if (amount.signum() < 0) try {
            throw new PaymentException("Amount must be >= 0");
        } catch (PaymentException e) {
            throw new RuntimeException(e);
        }
    }

    public static Money of(double amount, String currency) {
        return new Money(BigDecimal.valueOf(amount), currency);
    }
}
