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
@Table(name = "st_places")

public class StPlacesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_places_id")
    private Long stPlacesId;

    @Column(name = "st_places_places", nullable = false)
    private String stPlacesPlaces;

    @Column(name = "st_places_description", nullable = false)
    private String stPlacesDescription;

    @Column(name = "st_city_st_city_id", nullable = false)
    private Integer stCityStCityId;

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

    @Column(name = "OperationType")
    private String operationType;

    @Column(name = "Role")
    private String role;


}
