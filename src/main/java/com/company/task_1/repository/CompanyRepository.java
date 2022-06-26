package com.company.task_1.repository;

import com.company.task_1.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CompanyRepository extends JpaRepository<CompanyEntity, String> {

    @Transactional
    @Modifying
    @Query("update CompanyEntity set corpName=:corpName, directorName =:directorName, addressId =:aId where id = :id")
    int update(@Param("id") String id, @Param("corpName") String corpName, @Param("directorName") String directorName, @Param("aId") String aId);


    @Transactional
    @Modifying
    @Query("update CompanyEntity set visible=:visible  where id = :id")
    int changeVisible(@Param("id") String id, @Param("visible") boolean visible);
}
