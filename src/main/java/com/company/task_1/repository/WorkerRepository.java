package com.company.task_1.repository;

import com.company.task_1.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface WorkerRepository extends JpaRepository<WorkerEntity, String> {

    @Transactional
    @Modifying
    @Query("update WorkerEntity set name=:name, phoneNumber=:phone, address=:address, departmentId=:dId where id = :id")
    int update(@Param("id") String id, @Param("name") String name, @Param("address") String address, @Param("dId") String dId, @Param("phone") String phone);

    @Transactional
    @Modifying
    @Query("update WorkerEntity set visible=:visible  where id = :id")
    int changeVisible(@Param("id") String id, @Param("visible") boolean visible);
}