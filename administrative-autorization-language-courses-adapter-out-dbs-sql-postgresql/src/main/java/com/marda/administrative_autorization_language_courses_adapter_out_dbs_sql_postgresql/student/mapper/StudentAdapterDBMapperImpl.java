package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.mapper;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_authorization_language_courses_domain.person.Student;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.entity.StudentEntity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.exception.StudentAdapterDBException;

import java.util.List;

public class StudentAdapterDBMapperImpl implements StudentAdapterDBMapper {
    @Override
    public StudentEntity toEntity(Student student) throws StudentAdapterDBException {
        return StudentEntity
                .builder()
                .id(student.getId().asUuid())
                .firstName(student.getFirstName())
                .middleName(student.getMiddleName())
                .firstSurname(student.getFirstSurname())
                .secondSurname(student.getSecondSurname())
                .birthDate(student.getBirthDate())
                .idCredential(student.getIdCredential())
                .enrolledLanguageCourses(student.getEnrolledLanguageCourses())
                .phoneNumber(student.getPhoneNumber())
                .email(student.getEmail().getValue())
                .build();
    }

    @Override
    public Student toDomain(StudentEntity studentEntity) throws StudentAdapterDBException {
        try {
            return new Student(
                    Identity.of(studentEntity.getId()),
                    studentEntity.getFirstName(),
                    studentEntity.getMiddleName(),
                    studentEntity.getFirstSurname(),
                    studentEntity.getSecondSurname(),
                    studentEntity.getBirthDate(),
                    studentEntity.getIdCredential(),
                    studentEntity.getEnrolledLanguageCourses(),
                    studentEntity.getPhoneNumber(),
                    Email.fromDb(studentEntity.getEmail())
            );
        } catch (DomainException e) {
            throw new StudentAdapterDBException(e);
        }

    }

    @Override
    public List<Student> toDomain(List<StudentEntity> studentEntityList) throws StudentAdapterDBException {
        return studentEntityList.stream().map(studentEntity -> {
            try {
                return toDomain(studentEntity);
            } catch (StudentAdapterDBException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
