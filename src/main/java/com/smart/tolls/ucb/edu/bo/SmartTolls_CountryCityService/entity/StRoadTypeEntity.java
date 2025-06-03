package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "st_road_type")
public class StRoadTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoadType;

    private String roadType;

    private Integer roadTypeStatus;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.roadTypeStatus = 1;
    }
}
