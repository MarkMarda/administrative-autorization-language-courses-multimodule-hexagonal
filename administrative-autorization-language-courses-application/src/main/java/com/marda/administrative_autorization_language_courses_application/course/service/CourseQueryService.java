package com.marda.administrative_autorization_language_courses_application.course.service;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import com.marda.administrative_autorization_language_courses_application.course.port.in.CourseQueryFindByCourseUseCase;
import com.marda.administrative_autorization_language_courses_application.course.port.out.CourseQueryFindByCoursePort;

import java.util.List;

public class CourseQueryService implements CourseQueryFindByCourseUseCase {
    private final CourseQueryFindByCoursePort courseQueryFindByCoursePort;

    public CourseQueryService(CourseQueryFindByCoursePort courseQueryFindByCoursePort) {
        this.courseQueryFindByCoursePort = courseQueryFindByCoursePort;
    }

    @Override
    public List<Course> findByCourse(String course) throws CourseApplicationException {
        return courseQueryFindByCoursePort.findByCourse(course);
    }
}
