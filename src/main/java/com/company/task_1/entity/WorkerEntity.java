package com.company.task_1.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "worker")
public class WorkerEntity extends BaseEntity {
    @Column
    private String name;
    @Column
    private String phoneNumber;
    @Column
    private String address;

    @Column(name = "department_id")
    private String departmentId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private DepartmentEntity department;
}
