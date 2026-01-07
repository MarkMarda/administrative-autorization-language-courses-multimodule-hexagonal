package com.marda.administrative_autorization_language_courses_adapter_in_rest.student.mapper;

import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.dtos.StudentCreateRequestDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.exception.StudentAdapterRestException;
import com.marda.administrative_autorization_language_courses_application.student.port.in.dtos.CreateStudentCommand;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class StudentAdapterRestMapperImpl implements StudentAdapterRestMapper{
    @Override
    public CreateStudentCommand toCommand(StudentCreateRequestDto studentCreateRequestDto) {
        try {
            return new CreateStudentCommand(
                    studentCreateRequestDto.firstName(),
                    studentCreateRequestDto.middleName(),
                    studentCreateRequestDto.firstSurname(),
                    studentCreateRequestDto.secondSurname(),
                    LocalDate.parse(studentCreateRequestDto.birthDate()),
                    studentCreateRequestDto.idCredential(),
                    studentCreateRequestDto.enrolledLanguageCourses(),
                    studentCreateRequestDto.phoneNumber(),
                    Email.create(studentCreateRequestDto.email())
            );
        } catch (DomainException | DateTimeParseException e) {
            throw new StudentAdapterRestException("Invalid student data", e);
        }

    }
}
