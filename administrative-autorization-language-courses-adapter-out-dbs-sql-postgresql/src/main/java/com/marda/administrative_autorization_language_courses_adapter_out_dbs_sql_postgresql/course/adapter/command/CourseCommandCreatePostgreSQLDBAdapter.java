package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.adapter.command;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.entity.CourseEntity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.exception.CourseAdapterDBException;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper.CourseAdapterDBMapper;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.repository.CourseRepository;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import com.marda.administrative_autorization_language_courses_application.course.port.out.CourseCommandCreatePort;

public class CourseCommandCreatePostgreSQLDBAdapter implements CourseCommandCreatePort {
    private final CourseRepository courseRepository;

    private final CourseAdapterDBMapper courseAdapterDBMapper;

    private static final String MESSAGE_ERROR = "Error mapping Course Domain/Entity";

    public CourseCommandCreatePostgreSQLDBAdapter(
            CourseRepository courseRepository,
            CourseAdapterDBMapper courseAdapterDBMapper
    ) {
        this.courseRepository = courseRepository;
        this.courseAdapterDBMapper = courseAdapterDBMapper;
    }

    @Override
    public Course saveCourse(Course course) throws CourseApplicationException {
        try {
            CourseEntity entity = courseAdapterDBMapper.toEntity(course);

            CourseEntity saved = courseRepository.save(entity);

            return courseAdapterDBMapper.toDomain(saved);
        } catch (CourseAdapterDBException e) {
            throw new CourseApplicationException(MESSAGE_ERROR, e);
        }
    }
}
