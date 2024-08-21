package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "st_road_type")
public class StRoadTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_road_type_id")
    private Long stRoadTypeId;

    @Column(name = "st_road_type_type", nullable = false)
    private String stRoadTypeType;

    @Column(name = "st_road_type_description", nullable = false)
    private String stRoadTypeDescription;

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
    private Integer recordVersion;

    @Column(name  = "OperationType")
    private String operationType;

    @Column(name = "Role")
    private String role;



}
