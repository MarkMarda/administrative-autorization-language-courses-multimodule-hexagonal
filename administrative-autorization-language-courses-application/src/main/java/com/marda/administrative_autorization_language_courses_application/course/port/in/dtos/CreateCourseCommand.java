package com.marda.administrative_autorization_language_courses_application.course.port.in.dtos;

public record CreateCourseCommand(
        String code,   // e.g., B2-2025-ENG
        String name,   // e.g., Inglés B2
        String level
) {
}
