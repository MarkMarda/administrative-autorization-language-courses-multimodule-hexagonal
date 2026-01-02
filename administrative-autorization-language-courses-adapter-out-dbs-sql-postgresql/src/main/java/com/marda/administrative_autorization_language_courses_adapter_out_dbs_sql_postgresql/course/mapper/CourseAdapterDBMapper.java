package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.entity.CourseEntity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.exception.CourseAdapterDBException;

import java.util.List;

public interface CourseAdapterDBMapper {
    CourseEntity toEntity(Course course) throws CourseAdapterDBException;

    Course toDomain(CourseEntity courseEntity) throws CourseAdapterDBException;

    List<Course> toDomain(List<CourseEntity> courseEntityList) throws CourseAdapterDBException;
}
