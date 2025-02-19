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
@Table(name = "st_country")
public class StCountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_country_id")
    private Long idCountry;

    @Column(name = "st_country_name")
    private String countryName;

    @Column(name = "st_country_status")
    private Integer status;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.status = 1;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<StCityEntity> cities;
}
