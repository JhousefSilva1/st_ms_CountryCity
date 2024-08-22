package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "st_persons")
public class StPersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_person_id")
    private Long id;

    @Column(name = "st_person_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "st_person_surname", nullable = false, length = 100)
    private String lastName;

    @Column(name = "st_person_dni", nullable = false, length = 20, unique = true)
    private String dni;

    @Column(name = "st_person_birthdate", nullable = false)
    private Timestamp birthdate;

    @Column(name = "st_person_cellphone_number", length = 20)
    private String phoneNumber;

    @Column(name = "st_gender_st_gender_id", nullable = false)
    private Integer genderId;


    @Column(name = "st_country_st_country_id", nullable = false)
    private Integer countryId;

    @Column(name = "st_person_email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "st_person_password", nullable = false, length = 100)
    private String passwords;

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
    // Getters y Setters
}
