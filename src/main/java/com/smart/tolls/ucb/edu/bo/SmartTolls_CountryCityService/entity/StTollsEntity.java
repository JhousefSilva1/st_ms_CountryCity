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
@Table(name = "st_tolls")
public class StTollsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_tolls_id")
    private Long stTollsId;

    @Column(name = "st_tolls_tolls", nullable = false)
    private String stTollsTolls;

    @Column(name = "st_origin_places_st_places_id", nullable = false)
    private Long stOriginPlacesStPlacesId;

    @Column(name = "st_destination_places_st_places_id", nullable = false)
    private Long stDestinationPlacesStPlacesId;

    @Column(name = "st_tolls_cost", nullable = false)
    private Double stTollsCost;

    @Column(name = "st_road_type_st_road_type_id", nullable = false)
    private Long stRoadTypeStRoadTypeId;

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
