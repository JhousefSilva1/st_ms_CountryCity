package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "st_country")
public class StCountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCountry;

    private String countryName;

    private Integer countryStatus;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.countryStatus = 1;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<StCityEntity> cities;
}
