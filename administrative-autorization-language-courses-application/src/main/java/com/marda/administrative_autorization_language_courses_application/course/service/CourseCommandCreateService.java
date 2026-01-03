package com.marda.administrative_autorization_language_courses_application.course.service;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_authorization_language_courses_domain.exceptions.DomainException;
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
    public Course createCourse(CreateCourseCommand createCourseCommand) throws CourseApplicationException {
        Identity id = Identity.generate();

        try {
            Course course = new Course(
                    id,
                    createCourseCommand.code(),
                    createCourseCommand.name(),
                    createCourseCommand.level()
            );

            return courseCommandCreatePort.saveCourse(course);
        } catch (DomainException e) {
            throw new CourseApplicationException(e);
        }

    }
}
