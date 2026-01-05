package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.entity;

import com.marda.administrative_authorization_language_courses_domain.base.Identity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.base.GenericEntity;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper.IdentityAttributeConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "tbl_course")
@Entity(name = "CourseEntity")
public class CourseEntity extends GenericEntity {
    @Id
    @JdbcTypeCode(SqlTypes.UUID)
    //@GeneratedValue(strategy = GenerationType.UUID)
    @Convert(converter = IdentityAttributeConverter.class)
    @Column(name = "course_id", nullable = false)
    private Identity id;

    //B2-2025-ENG
    @NotNull(message = "code is required")
    @Column(name = "course_code", nullable = false)
    private String code;

    @NotNull(message = "name is required")
    @Column(name = "course_name", nullable = false)
    private String name;

    //A1, A2, B1, B2 etc.
    @NotNull(message = "level is required")
    @Column(name = "course_level", nullable = false)
    private String level;
}
