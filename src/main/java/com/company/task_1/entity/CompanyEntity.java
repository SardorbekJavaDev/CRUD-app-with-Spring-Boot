package com.company.task_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "company")
public class CompanyEntity extends BaseEntity {
    @Column(name = "corp_name")
    private String corpName;
    @Column(name = "director_name")
    private String directorName;

    @Column(name = "address_id")
    private String addressId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private AddressEntity address;
}
