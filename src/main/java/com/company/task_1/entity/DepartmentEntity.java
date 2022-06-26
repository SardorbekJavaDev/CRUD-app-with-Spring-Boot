package com.company.task_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
    @Column
    private String name;

    @Column
    private String companyId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "companyId", insertable = false,updatable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private CompanyEntity company;
}
