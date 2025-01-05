package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StPlacesRepository extends JpaRepository <StPlacesEntity, Long> {
    @Query("select b from StPlacesEntity b where b.status = 1 order by b.id asc")
    List<StPlacesEntity> findAllByStatus();

    @Query("select b from StPlacesEntity b where b.id=?1 and b.status=?2")
    StPlacesEntity findByIdAndByStatus(Long id, long status);
}
