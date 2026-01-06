package com.marda.administrative_authorization_language_courses_configuration.postgresql;

import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.adapter.command.CourseCommandFacade;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.adapter.command.CourseCommandRestAdapter;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.adapter.query.CourseQueryFacade;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.adapter.query.CourseQueryRestAdapter;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.mapper.CourseAdapterRestMapper;
import com.marda.administrative_autorization_language_courses_adapter_in_rest.course.mapper.CourseAdapterRestMapperImpl;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.adapter.command.CourseCommandCreatePostgreSQLDBAdapter;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.adapter.query.CourseQueryPostgreSQLDBAdapter;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper.CourseAdapterDBMapper;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.mapper.CourseAdapterDBMapperImpl;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.repository.CourseRepository;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.adapter.command.StudentCommandCreatePostgreSQLDBAdapter;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.mapper.StudentAdapterDBMapper;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.mapper.StudentAdapterDBMapperImpl;
import com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.repository.StudentRepository;
import com.marda.administrative_autorization_language_courses_application.course.port.in.CourseCommandCreateUseCase;
import com.marda.administrative_autorization_language_courses_application.course.port.in.CourseQueryFindByCourseUseCase;
import com.marda.administrative_autorization_language_courses_application.course.port.out.CourseCommandCreatePort;
import com.marda.administrative_autorization_language_courses_application.course.port.out.CourseQueryFindByCoursePort;
import com.marda.administrative_autorization_language_courses_application.course.service.CourseCommandCreateService;
import com.marda.administrative_autorization_language_courses_application.course.service.CourseQueryService;
import com.marda.administrative_autorization_language_courses_application.student.port.out.StudentCommandCreatePort;
import com.marda.administrative_autorization_language_courses_application.student.service.StudentCommandCreateService;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@EntityScan({
        "com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.entity",
        "com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.entity"
})
@EnableJpaRepositories(basePackages = {
        "com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.course.repository",
        "com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.student.repository"
})
@Configuration
public class AcademicPostgreSQLConfig {
    //
    @Bean(name = "academicDataSource")
    @Primary
    public DataSource academicDataSource(AcademicDataSourceProperties props) {
        return DataSourceBuilder.create()
                .url(props.url())
                .username(props.username())
                .password(props.password())
                .driverClassName(props.driverClassName())
                .build();
    }

    //
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            @Qualifier("academicDataSource") DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);

        em.setPackagesToScan("com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");

        em.setJpaProperties(props);

        return em;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    //Application - Service
    @Bean
    CourseCommandCreateService courseCommandCreateService(
            CourseCommandCreatePort courseCommandCreatePort
    ) {
        return new CourseCommandCreateService(courseCommandCreatePort);
    }

    @Bean
    CourseQueryService courseQueryService(
            CourseQueryFindByCoursePort courseQueryFindByCoursePort
    ) {
        return new CourseQueryService(courseQueryFindByCoursePort);
    }

    @Bean
    StudentCommandCreateService studentCommandCreateService(
            StudentCommandCreatePort studentCommandCreatePort
    ) {
        return new StudentCommandCreateService(studentCommandCreatePort);
    }

    //Adapters
    // Adapter - DBs - PostgreSQL
    @Bean
    CourseCommandCreatePostgreSQLDBAdapter courseCommandCreatePostgreSQLDBAdapter(
            CourseRepository courseRepository,
            CourseAdapterDBMapper courseAdapterDBMapper
    ) {
        return new CourseCommandCreatePostgreSQLDBAdapter(courseRepository, courseAdapterDBMapper);
    }

    @Bean
    CourseQueryPostgreSQLDBAdapter courseQueryPostgreSQLDBAdapter(
            CourseRepository courseRepository,
            CourseAdapterDBMapper courseAdapterDBMapper
    ) {
        return new CourseQueryPostgreSQLDBAdapter(courseRepository, courseAdapterDBMapper);
    }

    @Bean
    StudentCommandCreatePostgreSQLDBAdapter studentCommandCreatePostgreSQLDBAdapter(
            StudentRepository studentRepository,
            StudentAdapterDBMapper studentAdapterDBMapper
    ) {
        return new StudentCommandCreatePostgreSQLDBAdapter(studentRepository, studentAdapterDBMapper);
    }

    // Adapter - API Rest - Spring MVC
    @Bean
    CourseQueryFacade courseQueryFacade(
            CourseQueryFindByCourseUseCase courseQueryFindByCourseUseCase,
            CourseAdapterRestMapper courseAdapterRestMapper
    ) {
        return new CourseQueryFacade(courseQueryFindByCourseUseCase, courseAdapterRestMapper);
    }

    @Bean
    CourseQueryRestAdapter courseQueryRestAdapter(CourseQueryFacade courseQueryFacade) {
        return new CourseQueryRestAdapter(courseQueryFacade);
    }

    @Bean
    CourseCommandFacade courseCommandFacade(
            CourseCommandCreateUseCase courseCommandCreateUseCase,
            CourseAdapterRestMapper courseAdapterRestMapper
    ) {
        return new CourseCommandFacade(courseCommandCreateUseCase, courseAdapterRestMapper);
    }

    @Bean
    CourseCommandRestAdapter courseCommandRestAdapter(CourseCommandFacade courseCommandFacade) {
        return new CourseCommandRestAdapter(courseCommandFacade);
    }

    //Mappers
    // Mapper - DB
    @Bean
    StudentAdapterDBMapper studentAdapterDBMapper() {
        return new StudentAdapterDBMapperImpl();
    }

    @Bean
    CourseAdapterDBMapper courseAdapterDBMapper() {
        return new CourseAdapterDBMapperImpl();
    }

    // Mapper - Rest
    @Bean
    CourseAdapterRestMapper courseAdapterRestMapper() {
        return new CourseAdapterRestMapperImpl();
    }
}
