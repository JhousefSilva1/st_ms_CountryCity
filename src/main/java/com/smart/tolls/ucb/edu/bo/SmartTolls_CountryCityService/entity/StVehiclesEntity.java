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
    @Column(name = "st_vehicle_id")
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
