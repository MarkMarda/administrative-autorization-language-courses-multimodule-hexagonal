package com.marda.administrative_autorization_language_courses_adapter_out_dbs_sql_postgresql.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<E, ID> extends JpaRepository<E, ID> {
}
