package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.mapper;

import com.marda.administrative_authorization_language_courses_domain.person.Student;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.entity.StudentEntity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.exception.StudentAdapterDBException;

import java.util.List;

public interface StudentAdapterDBMapper {
    StudentEntity toEntity(Student student) throws StudentAdapterDBException;

    Student toDomain(StudentEntity studentEntity) throws StudentAdapterDBException;

    List<Student> toDomain(List<StudentEntity> studentEntityList) throws StudentAdapterDBException;
}
