package com.marda.administrative_autorization_language_courses_adapter_in_rest.student.dtos;

import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;
import lombok.Builder;

import java.util.List;

@Builder
public record StudentCreateRequestDto(
        String firstName,
        String middleName,
        String firstSurname,
        String secondSurname,
        String birthDate,
        Long idCredential,
        List<String> enrolledLanguageCourses,
        String phoneNumber,
        String email
) {
}
