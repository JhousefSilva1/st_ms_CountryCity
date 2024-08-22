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
@Table(name = "st_ticket")
public class StTicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_ticker_id", nullable = false)
    private Long id;

    @Column(name = "st_ticket_description", nullable = false, length = 100)
    private String description;

    @Column(name = "st_vehicles_st_vehicle_id", nullable = false)
    private Integer vehicleId;

    @Column(name = "st_lines_st_line_id", nullable = false)
    private Integer lineId;

    @Column(name = "st_ticket_date_hour", nullable = false)
    private LocalDateTime dateHour;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_by", length = 100)
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "deleted_by", length = 100)
    private String deletedBy;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @Column(name = "ip_address", length = 100)
    private String ipAddress;

    @Column(name = "action", length = 50)
    private String action;

    @Column(name = "previous_value", length = 100)
    private String previousValue;

    @Column(name = "current_value", length = 100)
    private String currentValue;

    @Column(name = "record_version", length = 10)
    private String recordVersion;

    @Column(name = "operation_type", length = 100)
    private String operationType;

    @Column(name = "role", length = 100)
    private String role;
}
