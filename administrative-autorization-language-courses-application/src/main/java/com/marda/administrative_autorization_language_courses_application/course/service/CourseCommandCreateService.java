package com.marda.administrative_autorization_language_courses_application.course.service;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import com.marda.administrative_autorization_language_courses_application.course.port.in.CourseCommandCreateUseCase;
import com.marda.administrative_autorization_language_courses_application.course.port.in.dtos.CreateCourseCommand;
import com.marda.administrative_autorization_language_courses_application.course.port.out.CourseCommandCreatePort;

public class CourseCommandCreateService implements CourseCommandCreateUseCase {
    private final CourseCommandCreatePort courseCommandCreatePort;

    public CourseCommandCreateService(CourseCommandCreatePort courseCommandCreatePort) {
        this.courseCommandCreatePort = courseCommandCreatePort;
    }

    @Override
    public void createCourse(CreateCourseCommand createCourseCommand) throws CourseApplicationException {
        if (createCourseCommand.code() == null || createCourseCommand.code().isBlank()) {
            throw new CourseApplicationException("Course code is required");
        }

        if (createCourseCommand.name() == null || createCourseCommand.name().isBlank()) {
            throw new CourseApplicationException("Course name is required");
        }

        if (createCourseCommand.level() == null || createCourseCommand.level().isBlank()) {
            throw new CourseApplicationException("Course level is required");
        }

        Identity id = Identity.generate();

        Course course = new Course(
                id,
                createCourseCommand.code(),
                createCourseCommand.name(),
                createCourseCommand.level()
        );

        courseCommandCreatePort.saveCourse(course);
    }
}
