package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.repository;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.base.GenericRepository;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.entity.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends GenericRepository<CourseEntity, Identity> {
    List<CourseEntity> findByCourse(String name);
}
