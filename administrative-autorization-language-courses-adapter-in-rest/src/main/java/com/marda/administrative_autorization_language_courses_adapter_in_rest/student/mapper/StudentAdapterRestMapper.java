package com.marda.administrative_autorization_language_courses_adapter_in_rest.student.mapper;

import com.marda.administrative_autorization_language_courses_adapter_in_rest.student.dtos.StudentCreateRequestDto;
import com.marda.administrative_autorization_language_courses_application.student.port.in.dtos.CreateStudentCommand;

public interface StudentAdapterRestMapper {
    // Query

    // Command
    CreateStudentCommand toCommand(StudentCreateRequestDto studentCreateRequestDto);

}
