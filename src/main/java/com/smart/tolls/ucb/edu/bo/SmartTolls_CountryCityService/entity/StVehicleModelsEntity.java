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
@Table(name = "st_vehicles_models")
public class StVehicleModelsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_vehicle_model_id")
    private Long id;

    @Column(name = "st_vehicle_model_model", nullable = false)
    private String vehicleModel;

    @Column(name = "st_vehicles_brands_st_vehicle_brand_id", nullable = false)
    private Integer stVehicleBrandStVehicleBrandId;

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
