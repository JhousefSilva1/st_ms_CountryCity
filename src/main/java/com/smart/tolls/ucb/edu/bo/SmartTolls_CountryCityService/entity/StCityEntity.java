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
@Table(name = "st_city")
public class StCityEntity {
    @Id
    @GeneratedValue


    private Long idCity;

    private String cityName;

    private Integer cityStatus;

    @ManyToOne
    @JoinColumn(name = "st_country_country_id", nullable = false)
    private StCountryEntity country;

    @JsonIgnore
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)

    private List<StPlacesEntity> places;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.cityStatus = 1;
    }
}
