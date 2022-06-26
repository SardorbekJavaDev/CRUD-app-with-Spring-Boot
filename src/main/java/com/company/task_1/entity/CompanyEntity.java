package com.company.task_1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "company")
public class CompanyEntity extends BaseEntity {
    @Column(name = "corp_name")
    private String corpName;
    @Column(name = "director_name")
    private String directorName;
    @Column(name = "address")
    private String address;
}
