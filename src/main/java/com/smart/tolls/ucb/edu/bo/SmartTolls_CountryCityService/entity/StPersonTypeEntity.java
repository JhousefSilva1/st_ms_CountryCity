//package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;
//import jakarta.persistence.*;
//import lombok.*;
//
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Entity
//@Table(name = "st_person_type")
//public class StPersonTypeEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "st_person_type_id")
//    private Long stPersonTypeId;
//
//    @Column(name = "st_person_type", length = 100)
//    private String stPersonType;
//
//    @Column(name = "created_by")
//    private String createdBy;
//
//    @Column(name = "created_date")
//    private LocalDateTime createdDate;
//
//    @Column(name = "modified_by")
//    private String modifiedBy;
//
//    @Column(name = "modified_date")
//    private LocalDateTime modifiedDate;
//
//    @Column(name = "is_deleted")
//    private Boolean isDeleted;
//
//    @Column(name = "deleted_by")
//    private String deletedBy;
//
//    @Column(name = "deleted_date")
//    private LocalDateTime deletedDate;
//
//    @Column(name = "ip_address")
//    private String ipAddress;
//
//    @Column(name = "action")
//    private String action;
//
//    @Column(name = "previous_value")
//    private String previousValue;
//
//    @Column(name = "current_value")
//    private String currentValue;
//
//    @Column(name = "record_version")
//    private String recordVersion;
//
//    @Column(name = "operation_type")
//    private String operationType;
//
//    @Column(name = "role")
//    private String role;
//
//    // Getters y Setters serán generados por Lombok
//}


package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "st_person_type")
public class StPersonTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_person_type_id")
    private Long stPersonTypeId;

    @Column(name = "st_person_type", length = 100)
    private String stPersonType;

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

//    @ManyToMany(mappedBy = "personTypes")
//    private Set<StPersonEntity> persons = new HashSet<>();

    // Getters y Setters serán generados por Lombok
}
