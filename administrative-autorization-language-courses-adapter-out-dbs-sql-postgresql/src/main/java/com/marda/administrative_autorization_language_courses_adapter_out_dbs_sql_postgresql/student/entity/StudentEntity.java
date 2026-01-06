package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.entity;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_authorization_language_courses_domain.person.vo.Email;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.base.GenericEntity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper.IdentityAttributeConverter;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.mapper.EmailAttributeConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "tbl_student")
@Entity(name = "StudentEntity")
public class StudentEntity extends GenericEntity {
    @Id
    @JdbcTypeCode(SqlTypes.UUID)
    //@Convert(converter = IdentityAttributeConverter.class) In case is useful
    @Column(name = "student_id", nullable = false, columnDefinition = "uuid")
    private UUID id;

    @NotNull(message = "firstName is required")
    @Column(name = "student_first_name", nullable = false)
    private String firstName;

    @Column(name = "student_middle_name")
    private String middleName;

    @NotNull(message = "firstSurname is required")
    @Column(name = "student_first_surname")
    private String firstSurname;

    @Column(name = "student_second_surname")
    private String secondSurname;

    @NotNull(message = "birthDate is required")
    @Column(name = "student_birth_date")
    private String birthDate;

    @NotNull(message = "idCredential is required")
    @Column(name = "student_id_credential")
    private Long idCredential;

    @Column(name = "student_enrolled_language_courses")
    private List<String> enrolledLanguageCourses;

    @NotNull(message = "phoneNumber is required")
    @Column(name = "student_phone_number")
    private String phoneNumber;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Convert(converter = EmailAttributeConverter.class)
    @NotNull(message = "email is required")
    @Column(name = "student_email")
    private Email email;
}
