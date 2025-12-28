package com.marda.administrative_autorization_language_courses_application.student.service;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.Student;
import com.marda.administrative_autorization_language_courses_application.student.exception.StudentApplicationException;
import com.marda.administrative_autorization_language_courses_application.student.port.in.StudentCommandCreateUseCase;
import com.marda.administrative_autorization_language_courses_application.student.port.in.dtos.CreateStudentCommand;
import com.marda.administrative_autorization_language_courses_application.student.port.out.StudentCommandCreatePort;

public class StudentCommandCreateService implements StudentCommandCreateUseCase {
    private final StudentCommandCreatePort studentCommandCreatePort;

    public StudentCommandCreateService(StudentCommandCreatePort studentCommandCreatePort) {
        this.studentCommandCreatePort = studentCommandCreatePort;
    }

    @Override
    public void createStudent(CreateStudentCommand createStudentCommand) throws StudentApplicationException {
        Identity id = Identity.generate();

        try {
            Student student = new Student(
                    id,
                    createStudentCommand.firstName(),
                    createStudentCommand.middleName(),
                    createStudentCommand.firstSurname(),
                    createStudentCommand.secondSurname(),
                    createStudentCommand.birthDate(),
                    createStudentCommand.idCredential(),
                    createStudentCommand.enrolledLanguageCourses(),
                    createStudentCommand.phoneNumber(),
                    createStudentCommand.email()
            );

            studentCommandCreatePort.saveStudent(student);

        } catch (DomainException e) {
            throw new StudentApplicationException(e.getMessage(), e);
        }
    }
}
