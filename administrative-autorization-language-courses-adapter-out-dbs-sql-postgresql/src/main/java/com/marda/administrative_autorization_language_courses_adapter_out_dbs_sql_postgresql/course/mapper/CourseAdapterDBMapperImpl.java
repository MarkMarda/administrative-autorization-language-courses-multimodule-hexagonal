package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.entity.CourseEntity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.exception.CourseAdapterDBException;

import java.util.List;

public class CourseAdapterDBMapperImpl implements CourseAdapterDBMapper {
    @Override
    public CourseEntity toEntity(Course course) throws CourseAdapterDBException {
        return CourseEntity
                .builder()
                .id(course.getId())
                .code(course.getCode())
                .name(course.getName())
                .level(course.getLevel())
                .build();
    }

    @Override
    public Course toDomain(CourseEntity courseEntity) throws CourseAdapterDBException {
        try {
            return new Course(
                    courseEntity.getId(),
                    courseEntity.getCode(),
                    courseEntity.getName(),
                    courseEntity.getLevel()
            );
        } catch (DomainException e) {
            throw new CourseAdapterDBException(e);
        }

    }

    @Override
    public List<Course> toDomain(List<CourseEntity> courseEntityList) throws CourseAdapterDBException {
        return courseEntityList.stream().map(courseEntity -> {
            try {
                return toDomain(courseEntity);
            } catch (CourseAdapterDBException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }
}
