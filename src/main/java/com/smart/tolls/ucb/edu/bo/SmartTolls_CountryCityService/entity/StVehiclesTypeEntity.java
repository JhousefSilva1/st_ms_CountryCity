package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "st_vehicle_type")
public class StVehiclesTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_vehicle_type_id")
    private Long id;

    @Column(name = "st_vehicle_type_type", nullable = false)
    private String vehicleType;

    @Column(name = "st_vehicles_doors", nullable = false)
    private String vehicleDoors;

    @Column(name = "st_vehicles_passengers", nullable = false)
    private String vehicleSeats;

    @Column(name =  "CreatedBy")
    private String createdBy;

    @Column(name = "CreatedDate")
    private String createdDate;

    @Column(name = "ModifiedBy")
    private String modifiedBy;

    @Column(name = "ModifiedDate")
    private String modifiedDate;

    @Column(name = "IsDeleted")
    private String isDeleted;

    @Column(name = "DeletedBy")
    private String deletedBy;

    @Column(name = "DeletedDate")
    private String deletedDate;

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




}
