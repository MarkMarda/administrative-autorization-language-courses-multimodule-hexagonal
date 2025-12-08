package com.marda.administrative_authorization_language_courses_domain.authorization;

public enum AuthorizationType {
    COURSE_ENROLLMENT,        // Matricula en curso
    LEVELING_EXAM,            // Examen de nivelacion
    CERTIFICATION_EXAM,       // Examen de certificación (TOEFL, DELF...)
    COURSE_CHANGE,            // Cambio de curso/nivel
    VALIDATION_PREVIOUS_STUDY,// Convalidación
    LATE_ENROLLMENT,          // Inscripción extemporánea
    PAYMENT_INSTALLMENT       // Pago fraccionado / autorizacion
}
