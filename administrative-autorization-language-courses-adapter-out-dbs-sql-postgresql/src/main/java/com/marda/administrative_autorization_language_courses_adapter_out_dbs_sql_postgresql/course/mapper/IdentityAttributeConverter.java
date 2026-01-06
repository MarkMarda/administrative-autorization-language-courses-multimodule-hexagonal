package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.UUID;

@Converter()
public class IdentityAttributeConverter implements AttributeConverter<Identity, UUID> {
    @Override
    public UUID convertToDatabaseColumn(Identity identity) {
        return (identity == null) ? null : identity.asUuid();
    }

    @Override
    public Identity convertToEntityAttribute(UUID uuid) {
        return (uuid == null) ? null : Identity.of(uuid);
    }
}
