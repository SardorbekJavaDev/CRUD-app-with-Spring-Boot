package com.company.task_1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseEntity{
    @Column
    private String name;
    @Column
    private String company;
}
