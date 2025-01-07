package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StRoadTypeRepository extends JpaRepository<StRoadTypeEntity, Long> {
    @Query("select b from StRoadTypeEntity b where b.status = 1 order by b.idRoadType asc")
    List<StRoadTypeEntity> findAllByStatus();

    @Query("select b from StRoadTypeEntity b where b.idRoadType=?1 and b.status=?2")
    StRoadTypeEntity findByIdAndByStatus(Long id, long status);
}
