package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.adapter.command;

import com.marda.administrative_authorization_language_courses_domain.person.Student;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.entity.StudentEntity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.exception.StudentAdapterDBException;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.mapper.StudentAdapterDBMapper;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.repository.StudentRepository;
import com.marda.administrative_autorization_language_courses_application.student.exception.StudentApplicationException;
import com.marda.administrative_autorization_language_courses_application.student.port.out.StudentCommandCreatePort;

public class StudentCommandCreatePostgreSQLDBAdapter implements StudentCommandCreatePort {
    private final StudentRepository studentRepository;

    private final StudentAdapterDBMapper studentAdapterDBMapper;

    private static final String MESSAGE_ERROR = "Error mapping Course Domain/Entity";

    public StudentCommandCreatePostgreSQLDBAdapter(StudentRepository studentRepository, StudentAdapterDBMapper studentAdapterDBMapper) {
        this.studentRepository = studentRepository;
        this.studentAdapterDBMapper = studentAdapterDBMapper;
    }

    @Override
    public Student saveStudent(Student student) throws StudentApplicationException {
        try {
            StudentEntity entity = studentAdapterDBMapper.toEntity(student);

            StudentEntity saved = studentRepository.save(entity);

            return studentAdapterDBMapper.toDomain(saved);
        } catch (StudentAdapterDBException e) {
            throw new StudentApplicationException(MESSAGE_ERROR, e);
        }
    }
}
