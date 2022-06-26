package com.company.task_1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "address")
public class AddressEntity extends BaseEntity{
    @Column
    private String street;
    @Column(name = "home_number")
    private String homeNumber;
}
