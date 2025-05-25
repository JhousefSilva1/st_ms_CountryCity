package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StCityRepository extends JpaRepository<StCityEntity, Long> {
    @Query("select b from StCityEntity b where b.cityStatus = 1 order by b.idCity asc")
    List<StCityEntity> findAllByStatus();

    @Query("select b from StCityEntity b where b.idCity=?1 and b.cityStatus=?2")
    StCityEntity findByIdAndByStatus(Long id, long status);

    @Query("select b from StCityEntity b where b.country.idCountry=?1 and b.cityStatus=1" )
    List<StCityEntity> findByCountryAndByStatus(Long id);


//    query get CountryId by cituId
    @Query("select  b from StCityEntity b where b.idCity=?1")
    StCityEntity findByIdCity(Long id);
}
