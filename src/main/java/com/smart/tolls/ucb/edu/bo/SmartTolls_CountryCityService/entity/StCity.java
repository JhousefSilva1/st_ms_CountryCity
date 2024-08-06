package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;


import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "st_city")
public class StCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_city_id")
    private int id;

    @Column(name = "st_city_city", nullable = false, length = 100)
    private String city;

    @Column(name = "st_country_st_country_id", nullable = false)
    private int countryId;

    @Column(name = "CreatedBy", length = 100)
    private String createdBy;

    @Column(name = "CreatedDate")
    private Timestamp createdDate;

    @Column(name = "ModifiedBy", length = 100)
    private String modifiedBy;

    @Column(name = "ModifiedDate")
    private Timestamp modifiedDate;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @Column(name = "DeletedBy", length = 100)
    private String deletedBy;

    @Column(name = "DeletedDate")
    private Timestamp deletedDate;

    @Column(name = "IPAddress", length = 100)
    private String ipAddress;

    @Column(name = "Action", length = 50)
    private String action;

    @Column(name = "PreviousValue", length = 100)
    private String previousValue;

    @Column(name = "CurrentValue", length = 100)
    private String currentValue;

    @Column(name = "RecordVersion", length = 10)
    private String recordVersion;

    @Column(name = "OperationType", length = 100)
    private String operationType;

    @Column(name = "Role", length = 100)
    private String role;


}
