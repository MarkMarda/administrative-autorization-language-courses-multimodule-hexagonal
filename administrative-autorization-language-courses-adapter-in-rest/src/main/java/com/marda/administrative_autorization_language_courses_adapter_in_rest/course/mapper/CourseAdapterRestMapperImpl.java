package com.marda.administrative_autorization_language_courses_adapter_in_rest.course.mapper;

import com.marda.administrative_authorization_language_courses_domain.course.Course;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseCreateRequestDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseQueryResponseDto;
import com.marda.administrative_autorization_language_courses_application.course.port.in.dtos.CreateCourseCommand;

import java.util.List;

public class CourseAdapterRestMapperImpl implements CourseAdapterRestMapper{
    @Override
    public CourseQueryResponseDto toDto(Course course) {
        return CourseQueryResponseDto
                .builder()
                .id(course.getId().asUuid())
                .name(course.getName())
                .code(course.getCode())
                .level(course.getLevel())
                .build();
    }

    @Override
    public List<CourseQueryResponseDto> toDto(List<Course> courseList) {
        return courseList.stream().map(this::toDto).toList();
    }

    @Override
    public CreateCourseCommand toCommand(CourseCreateRequestDto courseCreateRequestDto) {
        return new CreateCourseCommand(
                courseCreateRequestDto.code(),
                courseCreateRequestDto.name(),
                courseCreateRequestDto.level()
        );
    }
}
