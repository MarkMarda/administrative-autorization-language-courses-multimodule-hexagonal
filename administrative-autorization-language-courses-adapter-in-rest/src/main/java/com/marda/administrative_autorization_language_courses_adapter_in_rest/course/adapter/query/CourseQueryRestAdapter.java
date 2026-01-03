package com.marda.administrative_autorization_language_courses_adapter_in_rest.course.adapter.query;

import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.controller.CourseQueryRestController;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseQueryResponseDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.exception.CourseAdapterRestException;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class CourseQueryRestAdapter implements CourseQueryRestController {
    private final CourseQueryFacade courseQueryFacade;

    public CourseQueryRestAdapter(CourseQueryFacade courseQueryFacade) {
        this.courseQueryFacade = courseQueryFacade;
    }

    @Override
    public ResponseEntity<List<CourseQueryResponseDto>> findByCourse(String course) throws CourseAdapterRestException {
        try {
            return courseQueryFacade.findByCourse(course);
        } catch (CourseApplicationException e) {
            throw new CourseAdapterRestException(e);
        }
    }
}
