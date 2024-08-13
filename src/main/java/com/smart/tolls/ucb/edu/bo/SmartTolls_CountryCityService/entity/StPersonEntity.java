package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

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

    @Column(name = "st_person_first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "st_person_last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "st_person_email", nullable = false, length = 150, unique = true)
    private String email;

    @Column(name = "st_person_dni", nullable = false, length = 20, unique = true)
    private String dni;

    @ManyToOne
    @JoinColumn(name = "st_gender_st_gender_id", nullable = false)
    private StGenderEntity gender;

    @ManyToOne
    @JoinColumn(name = "st_country_st_country_id", nullable = false)
    private StCountryEntity country;

    @ManyToOne
    @JoinColumn(name = "st_city_st_city_id", nullable = false)
    private StCityEntity city;

    @Column(name = "st_person_address", length = 200)
    private String address;

    @Column(name = "st_person_phone_number", length = 20)
    private String phoneNumber;

    // Auditoría
    @Column(name = "CreatedBy", length = 100)
    private String createdBy;

    @Column(name = "CreatedDate")
    private Timestamp createdDate;

    @Column(name = "ModifiedBy", length = 100)
    private String modifiedBy;

    @Column(name = "ModifiedDate")
    private Timestamp modifiedDate;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @Column(name = "DeletedBy", length = 100)
    private String deletedBy;

    @Column(name = "DeletedDate")
    private Timestamp deletedDate;

    @Column(name = "IPAddress", length = 100)
    private String ipAddress;

    @Column(name = "Action", length = 50)
    private String action;

    @Column(name = "PreviousValue", length = 100)
    private String previousValue;

    @Column(name = "CurrentValue", length = 100)
    private String currentValue;

    @Column(name = "RecordVersion", length = 10)
    private String recordVersion;

    @Column(name = "OperationType", length = 100)
    private String operationType;

    @Column(name = "Role", length = 100)
    private String role;

    // Getters y Setters
}
