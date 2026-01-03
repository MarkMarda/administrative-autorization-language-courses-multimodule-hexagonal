package com.marda.administrative_autorization_language_courses_adapter_in_rest.course.adapter.command;

import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.controller.CourseCommandRestController;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseCreateRequestDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseCreateResponseDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.exception.CourseAdapterRestException;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CourseCommandRestAdapter implements CourseCommandRestController {
    private final CourseCommandFacade courseCommandFacade;

    public CourseCommandRestAdapter(CourseCommandFacade courseCommandFacade) {
        this.courseCommandFacade = courseCommandFacade;
    }

    @Override
    public ResponseEntity<CourseCreateResponseDto> createCourse(CourseCreateRequestDto courseCreateRequestDto) throws CourseAdapterRestException {
        try {
            return courseCommandFacade.createCourse(courseCreateRequestDto);
        } catch (CourseApplicationException e) {
            throw new CourseAdapterRestException(e);
        }
    }
}
