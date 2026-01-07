package com.marda.administrative_autorization_language_courses_adapter_in_rest.student.adapter.command;

import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.dtos.StudentCreateRequestDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.dtos.StudentCreateResponseDto;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.exception.StudentAdapterRestException;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.mapper.StudentAdapterRestMapper;
import com.marda.administrative_autorization_language_courses_application.student.exception.StudentApplicationException;
import com.marda.administrative_autorization_language_courses_application.student.port.in.StudentCommandCreateUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class StudentCommandFacade {
    private final StudentCommandCreateUseCase studentCommandCreateUseCase;

    private final StudentAdapterRestMapper studentAdapterRestMapper;

    private static final String MESSAGE_CREATED = "El estudiante fue creado correctamente";

    public StudentCommandFacade(
            StudentCommandCreateUseCase studentCommandCreateUseCase,
            StudentAdapterRestMapper studentAdapterRestMapper
    ) {
        this.studentCommandCreateUseCase = studentCommandCreateUseCase;
        this.studentAdapterRestMapper = studentAdapterRestMapper;
    }

    public ResponseEntity<StudentCreateResponseDto> createStudent(StudentCreateRequestDto studentCreateRequestDto) throws StudentAdapterRestException, StudentApplicationException {
        var command = studentAdapterRestMapper.toCommand(studentCreateRequestDto);

        var studentCreated = studentCommandCreateUseCase.createStudent(command);

        var response = StudentCreateResponseDto
                .builder()
                .message(MESSAGE_CREATED)
                .idCredential(studentCreated.getIdCredential())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
