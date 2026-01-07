package com.marda.administrative_autorization_language_courses_adapter_in_rest.student.adapter.command;

import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.controller.StudentCommandRestController;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.dtos.StudentCreateRequestDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.dtos.StudentCreateResponseDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.exception.StudentAdapterRestException;
import com.marda.administrative_autorization_language_courses_application.student.exception.StudentApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StudentCommandRestAdapter implements StudentCommandRestController {
    private final StudentCommandFacade studentCommandFacade;

    public StudentCommandRestAdapter(StudentCommandFacade studentCommandFacade) {
        this.studentCommandFacade = studentCommandFacade;
    }

    @Override
    public ResponseEntity<StudentCreateResponseDto> createStudent(StudentCreateRequestDto studentCreateRequestDto) throws StudentAdapterRestException {
        try {
            return studentCommandFacade.createStudent(studentCreateRequestDto);
        } catch (StudentApplicationException e) {
            throw new StudentAdapterRestException(e);
        }
    }
}
