package com.marda.administrative_authorization_language_courses_configuration.postgresql;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.datasource.postgresql")
public record AcademicDataSourceProperties(
        String url,
        String username,
        String password,
        String driverClassName
) {
}
