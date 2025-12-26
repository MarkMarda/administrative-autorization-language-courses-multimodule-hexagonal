package com.marda.administrative_autorization_language_courses_application.course.port.out;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;

@FunctionalInterface
public interface CourseCommandCreatePort {
    Course saveCourse(Course course) throws CourseApplicationException;
}
