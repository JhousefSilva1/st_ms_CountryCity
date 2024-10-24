package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name = "st_city_id")
    private Long idCity;

    @Column(name = "st_city_name")
    private String cityName;

    @Column(name = "st_city_status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "st_country_st_country_id", nullable = false)
    private StCountryEntity country;

    @Embedded
    private Audit audit = new Audit();

    @PrePersist
    public void prePersist() {
        this.status = 1;
    }
}
