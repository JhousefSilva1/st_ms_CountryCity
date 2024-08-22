package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import jakarta.ws.rs.GET;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "st_persons_st_persons_type")
public class StPersonsStPersonsTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_persons_st_persons_type")
    private Long stPersonsStPersonsTypeId;

    @Column(name = "st_person_type_st_person_type_id")
    private Integer stPersonTypeId;

    @Column(name = "st_persons_st_person_id")
    private Integer stPersonId;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "deleted_by")
    private String deletedBy;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "action")
    private String action;

    @Column(name = "previous_value")
    private String previousValue;

    @Column(name = "current_value")
    private String currentValue;

    @Column(name = "record_version")
    private String recordVersion;

    @Column(name = "operation_type")
    private String operationType;

    @Column(name = "role")
    private String role;

}
