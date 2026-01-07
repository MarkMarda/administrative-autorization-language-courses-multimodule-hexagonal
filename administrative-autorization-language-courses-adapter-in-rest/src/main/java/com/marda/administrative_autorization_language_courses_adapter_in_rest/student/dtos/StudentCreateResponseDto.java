package com.marda.administrative_autorization_language_courses_adapter_in_rest.student.dtos;

import lombok.Builder;

@Builder
public record StudentCreateResponseDto(
        String message,
        Long idCredential
) {
}
