package com.marda.administrative_autorization_language_courses_application.course.port.out;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;

import java.util.List;

@FunctionalInterface
public interface CourseQueryFindByCoursePort {
    List<Course> findByCourse(String name) throws CourseApplicationException;
}
