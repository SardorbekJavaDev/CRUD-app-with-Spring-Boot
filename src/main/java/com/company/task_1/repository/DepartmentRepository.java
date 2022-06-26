package com.company.task_1.repository;

import com.company.task_1.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, String> {

    @Transactional
    @Modifying
    @Query("update DepartmentEntity set name=:name, company =:company where id = :id")
    int update(@Param("id") String id, @Param("name") String name, @Param("company") String company);


    @Transactional
    @Modifying
    @Query("update DepartmentEntity set visible=:visible  where id = :id")
    int changeVisible(@Param("id") String id, @Param("visible") boolean visible);
}