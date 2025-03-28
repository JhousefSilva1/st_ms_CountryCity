package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "st_tolls")
public class StTollsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTolls;

    private String tollsName;

    @ManyToOne
    @JoinColumn(name = "st_places_places_id", nullable = false)
    private StPlacesEntity places;

    private Integer tollsStatus;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.tollsStatus = 1;
    }
}
