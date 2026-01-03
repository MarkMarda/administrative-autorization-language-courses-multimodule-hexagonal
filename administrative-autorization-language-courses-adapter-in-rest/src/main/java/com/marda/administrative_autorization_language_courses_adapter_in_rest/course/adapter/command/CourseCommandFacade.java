package com.marda.administrative_autorization_language_courses_adapter_in_rest.course.adapter.command;

import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseCreateRequestDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.dtos.CourseCreateResponseDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.exception.CourseAdapterRestException;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.mapper.CourseAdapterRestMapper;
import com.marda.administrative_autorization_language_courses_application.course.exception.CourseApplicationException;
import com.marda.administrative_autorization_language_courses_application.course.port.in.CourseCommandCreateUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CourseCommandFacade {
    private final CourseCommandCreateUseCase courseCommandCreateUseCase;

    private final CourseAdapterRestMapper courseAdapterRestMapper;

    private static final String MESSAGE_CREATED = "El curso fue creado correctamente";


    public CourseCommandFacade(
            CourseCommandCreateUseCase courseCommandCreateUseCase,
            CourseAdapterRestMapper courseAdapterRestMapper
    ) {
        this.courseCommandCreateUseCase = courseCommandCreateUseCase;
        this.courseAdapterRestMapper = courseAdapterRestMapper;
    }

    public ResponseEntity<CourseCreateResponseDto> createCourse(CourseCreateRequestDto courseCreateRequestDto) throws CourseAdapterRestException, CourseApplicationException {
        var command = courseAdapterRestMapper.toCommand(courseCreateRequestDto);
        var courseCreated = courseCommandCreateUseCase.createCourse(command);

        var response = CourseCreateResponseDto
                .builder()
                .message(MESSAGE_CREATED)
                .code(courseCreated.getCode())
                .name(courseCreated.getName())
                .level(courseCreated.getLevel())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
