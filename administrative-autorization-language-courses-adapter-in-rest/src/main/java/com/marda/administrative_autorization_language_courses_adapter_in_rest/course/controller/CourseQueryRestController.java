package com.marda.administrative_autorization_language_courses_adapter_in_rest.course.controller;

import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseQueryResponseDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.exception.CourseAdapterRestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.marda.administrative_autorization_language_courses_adapter_in_rest.constants.APIConstants.API_COURSE_QUERY;

@RequestMapping(API_COURSE_QUERY)
public interface CourseQueryRestController {
    //End-points
    @GetMapping("/find-by-course/{course}")
    public ResponseEntity<List<CourseQueryResponseDto>> findByCourse(@PathVariable("course") String course) throws CourseAdapterRestException;

    //OpenApi Specification (Swagger Docs)
}
