package com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import lombok.Builder;

@Builder
public record CourseQueryResponseDto(
        Identity id,
        String code,   // e.g., B2-2025-ENG
        String name,   // e.g., Inglés B2
        String level
) {
}
