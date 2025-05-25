package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StPlacesRepository extends JpaRepository<StPlacesEntity, Long> {
    @Query("select b from StPlacesEntity b where b.placesStatus = 1 order by b.idPlaces asc")
    List<StPlacesEntity> findAllByStatus();

    @Query("select b from StPlacesEntity b where b.idPlaces=?1 and b.placesStatus=?2")
    StPlacesEntity findByIdAndByStatus(Long id, long status);

    @Query("select b from StPlacesEntity b where b.city.idCity=?1 and b.placesStatus=1")
    List<StPlacesEntity>findPlacesByCityId(Long id);
}
