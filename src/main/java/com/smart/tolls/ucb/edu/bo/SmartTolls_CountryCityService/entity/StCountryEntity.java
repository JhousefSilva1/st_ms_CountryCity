package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "st_country")
public class StCountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_country_id")
    private Integer id;

    @Column(name = "st_country_country_name", nullable = false)
    private String countryName;

    @Column(name = "CreatedBy")
    private String createdBy;

    @Column(name = "CreatedDate")
    private LocalDateTime createdDate;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @Column(name = "DeletedBy")
    private String deletedBy;

    @Column(name = "DeletedDate")
    private LocalDateTime deletedDate;

    @Column(name = "IPAddress")
    private String ipAddress;

    @Column(name = "Action")
    private String action;

    @Column(name = "PreviousValue")
    private String previousValue;

    @Column(name = "CurrentValue")
    private String currentValue;

    @Column(name = "RecordVersion")
    private String recordVersion;

    @Column(name = "OperationType")
    private String operationType;

    @Column(name = "Role")
    private String role;
}
