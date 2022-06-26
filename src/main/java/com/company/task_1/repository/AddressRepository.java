package com.company.task_1.repository;

import com.company.task_1.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AddressRepository extends JpaRepository<AddressEntity, String> {

    @Transactional
    @Modifying
    @Query("update AddressEntity set street=:street, homeNumber =:homeNumber where id = :id")
    int update(@Param("id") String id, @Param("street") String street, @Param("homeNumber") String homeNumber);


    @Transactional
    @Modifying
    @Query("update AddressEntity set visible=:visible  where id = :id")
    int changeVisible(@Param("id") String id, @Param("visible") boolean visible);
}