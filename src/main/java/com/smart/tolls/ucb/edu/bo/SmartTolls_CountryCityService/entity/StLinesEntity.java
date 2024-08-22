package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "st_lines")
public class StLinesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_line_id")
    private int lineId;

    @Column(name = "st_line_line")
    private String line;

    @Column(name = "st_tolls_st_tolls_id")
    private Integer tollsId;

    @Column(name = "createdby",nullable = false)
    private String createdBy;

    @Column(name = "createddate",nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "modifiedby",nullable = false)
    private String modifiedBy;

    @Column(name = "modifieddate",nullable = false)
    private LocalDateTime modifiedDate;


    @Column(name = "isdeleted",nullable = false)
    private Boolean isDeleted;

    @Column(name = "deletedby",nullable = false)
    private String deletedBy;

    @Column(name = "deleteddate",nullable = false)
    private LocalDateTime deletedDate;

    @Column(name = "ipaddress",nullable = false)
    private String ipAddress;

    @Column(name = "action",nullable = false)
    private String action;

    @Column(name = "previousvalue",nullable = false)
    private String previousValue;

    @Column(name = "currentvalue",nullable = false)
    private String currentValue;

    @Column(name = "recordversion",nullable = false)
    private String recordVersion;

    @Column(name = "operationtype",nullable = false)
    private String operationType;

    @Column(name = "role",nullable = false)
    private String role;



}
