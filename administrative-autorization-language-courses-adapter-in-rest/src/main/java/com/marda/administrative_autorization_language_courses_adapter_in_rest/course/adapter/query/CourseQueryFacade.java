package com.marda.administrative_autorization_language_courses_adapter_in_rest.course.adapter.query;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseQueryResponseDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.exception.CourseAdapterRestException;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.mapper.CourseAdapterRestMapper;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import com.marda.administrative_autorization_language_courses_application.course.port.in.CourseQueryFindByCourseUseCase;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CourseQueryFacade {
    private final CourseQueryFindByCourseUseCase courseQueryFindByCourseUseCase;

    private final CourseAdapterRestMapper courseAdapterRestMapper;

    public CourseQueryFacade(
            CourseQueryFindByCourseUseCase courseQueryFindByCourseUseCase,
            CourseAdapterRestMapper courseAdapterRestMapper
    ) {
        this.courseQueryFindByCourseUseCase = courseQueryFindByCourseUseCase;
        this.courseAdapterRestMapper = courseAdapterRestMapper;
    }

    public ResponseEntity<List<CourseQueryResponseDto>> findByCourse(String course) throws CourseAdapterRestException, CourseApplicationException {
        List<Course> courseList = courseQueryFindByCourseUseCase.findByCourse(course);

        if (courseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(courseAdapterRestMapper.toDto(courseList));
    }
}
