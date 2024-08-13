package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "st_gender")
public class StGenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_gender_id")
    private Long id;

    @Column(name = "st_gender_gender", nullable = false)
    private String gender;

    @Column(name = "st_gender_description", nullable = false)
    private String description;

    @Column(name = "createby")
    private String createdBy;

    @Column(name = "createddate")
    private LocalDateTime createdDate;

    @Column(name = "modifiedby")
    private String modifiedBy;

    @Column(name = "modifieddate")
    private LocalDateTime modifiedDate;

    @Column(name = "isdeleted")
    private Boolean isDeleted;

    @Column(name = "deletedby")
    private String deletedBy;

    @Column(name = "deleteddate")
    private LocalDateTime deletedDate;

    @Column(name = "ipaddress")
    private String ipAddress;

    @Column(name = "action")
    private String action;

    @Column(name = "previousvalue")
    private String previousValue;

    @Column(name = "currentvalue")
    private String currentValue;

    @Column(name = "recordversion")
    private String recordVersion;

    @Column(name = "operationtype")
    private String operationType;

    @Column(name = "role")
    private String role;
}