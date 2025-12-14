package com.marda.administrative_authorization_language_courses_domain.base;

import java.util.Objects;
import java.util.UUID;

public final class Identity {
    private final UUID value;

    private Identity(UUID value) {
        this.value = Objects.requireNonNull(value);
    }

    public static Identity generate() {
        return new Identity(UUID.randomUUID());
    }

    public static Identity of(UUID uuid) {
        return new Identity(uuid);
    }

    public UUID asUuid() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identity other)) return false;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
