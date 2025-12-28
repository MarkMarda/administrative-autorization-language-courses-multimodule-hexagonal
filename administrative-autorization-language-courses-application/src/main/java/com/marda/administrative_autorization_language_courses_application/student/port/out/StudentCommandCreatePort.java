package com.marda.administrative_autorization_language_courses_application.student.port.out;

import com.marda.administrative_authorization_language_courses_domain.person.Student;
import com.marda.administrative_autorization_language_courses_application.student.exception.StudentApplicationException;

@FunctionalInterface
public interface StudentCommandCreatePort {
    Student saveStudent(Student student) throws StudentApplicationException;
}
