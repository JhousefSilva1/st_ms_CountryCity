package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "st_places")
public class StPlacesEntity {

    @Id
    @GeneratedValue
    @Column(name = "st_places_id")
    private Long idPlaces;

    private String placeName;

    private Integer status;

    @ManyToOne
    @JoinColumn(name = "st_city_st_city_id", nullable = false)
    private StCityEntity city;

    @JsonIgnore
    @OneToMany(mappedBy = "places", fetch = FetchType.LAZY)
    private List<StTollsEntity> tolls;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.status = 1;
    }
}
