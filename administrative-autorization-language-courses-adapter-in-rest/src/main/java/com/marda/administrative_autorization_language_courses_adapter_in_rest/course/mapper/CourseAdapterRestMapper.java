package com.marda.administrative_autorization_language_courses_adapter_in_rest.course.mapper;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseCreateRequestDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseQueryResponseDto;
import com.marda.administrative_autorization_language_courses_application.course.port.in.dtos.CreateCourseCommand;

import java.util.List;

public interface CourseAdapterRestMapper {
    // Query
    CourseQueryResponseDto toDto(Course course);
    List<CourseQueryResponseDto> toDto(List<Course> courseList);

    // Command
    CreateCourseCommand toCommand(CourseCreateRequestDto courseCreateRequestDto);
}
