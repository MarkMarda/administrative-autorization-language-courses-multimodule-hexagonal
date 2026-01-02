package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.adapter.query;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.exception.CourseAdapterDBException;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper.CourseAdapterDBMapper;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.repository.CourseRepository;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import com.marda.administrative_autorization_language_courses_application.course.port.out.CourseQueryFindByCoursePort;

import java.util.List;

public class CourseQueryPostgreSQLDBAdapter implements CourseQueryFindByCoursePort {
    private final CourseRepository courseRepository;

    private final CourseAdapterDBMapper courseAdapterDBMapper;

    public CourseQueryPostgreSQLDBAdapter(
            CourseRepository courseRepository,
            CourseAdapterDBMapper courseAdapterDBMapper
    ) {
        this.courseRepository = courseRepository;
        this.courseAdapterDBMapper = courseAdapterDBMapper;
    }

    @Override
    public List<Course> findByCourse(String name) throws CourseApplicationException {
        try {
            return courseAdapterDBMapper.toDomain(courseRepository.findByCourse(name));
        } catch (CourseAdapterDBException e) {
            throw new CourseApplicationException(e);
        }
    }
}
