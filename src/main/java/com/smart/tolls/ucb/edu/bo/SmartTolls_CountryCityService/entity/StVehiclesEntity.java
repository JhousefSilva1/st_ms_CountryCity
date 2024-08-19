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
@Table(name = "st_vehicles")
public class StVehiclesEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "st_vehicles_id")
    private Long stVehiclesId;


    @Column(name = "st_vehicles_models_st_vehicle_model_id", nullable = false)
    private Integer stVehiclesModelsStVehicleModelId;

    @Column(name = "st_persons_st_person_id")
    private Integer stPersonsStPersonId;

    @Column(name = "st_fuel_types_st_fuel_type_id")
    private Integer stFuelTypesStFuelTypeId;

    @Column(name = "st_vehicle_type_st_vehicle_type_id")
    private Integer stVehicleTypeStVehicleTypeId;

    @Column(name = "st_vehicles_color")
    private String stVehiclesColor;

    @Column(name = "st_vehicles_plate")
    private String stVehiclesPlate;

    @Column(name = "st_vehicles_chasis_number")
    private String stVehiclesChasisNumbe;

    @Column(name = "st_vehicle_weight")
    private String stVehicleWeight;

    @Column(name = "st_vehicle_manufacture_year")
    private String stVehicleManufactureYear;

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
