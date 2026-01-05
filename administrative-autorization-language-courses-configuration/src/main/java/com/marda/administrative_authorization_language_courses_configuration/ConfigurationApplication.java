package com.marda.administrative_authorization_language_courses_configuration;

import com.marda.administrative_authorization_language_courses_configuration.postgresql.AcademicDataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        AcademicDataSourceProperties.class,
})
public class ConfigurationApplication {
}
