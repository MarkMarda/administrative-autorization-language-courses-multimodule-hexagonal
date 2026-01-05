package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.mapper;

import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EmailAttributeConverter implements AttributeConverter<Email, String> {
    @Override
    public String convertToDatabaseColumn(Email email) {
        return email == null ? null : email.getValue();
    }

    @Override
    public Email convertToEntityAttribute(String dbValue) {
        try {
            return dbValue == null ? null : Email.create(dbValue);
        } catch (DomainException e) {
            throw new RuntimeException(e);
        }
    }
}
