package com.marda.administrative_autorization_language_courses_application.course.port.in.dtos;

import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import com.marda.administrative_autorization_language_courses_application.student.exception.StudentApplicationException;

public record CreateCourseCommand(
        String code,   // e.g., B2-2025-ENG
        String name,   // e.g., Inglés B2
        String level
) {
    private static final String MESSAGE_NOT_BLANK = "must not be blank";
    private static final String MANDATORY_CODE = "code";
    private static final String MANDATORY_NAME = "name";
    private static final String MANDATORY_LEVEL = "level";

    public CreateCourseCommand {
        try {
            requireNotBlank(code, MANDATORY_CODE);
            requireNotBlank(name, MANDATORY_NAME);
            requireNotBlank(level, MANDATORY_LEVEL);
        } catch (CourseApplicationException e) {
            throw new RuntimeException(e);
        }
    }

    private static void requireNotBlank(String value, String field) throws CourseApplicationException {
        if (value == null || value.isBlank()) {
            throw new CourseApplicationException(field + " " + MESSAGE_NOT_BLANK);
        }
    }
}
