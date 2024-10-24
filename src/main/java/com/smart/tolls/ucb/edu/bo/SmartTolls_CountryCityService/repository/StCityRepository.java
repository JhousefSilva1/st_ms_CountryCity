package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StCityRepository extends JpaRepository<StCityEntity, Long> {
    @Query("select b from StCityEntity b where b.status = 1 order by b.id asc")
    List<StCityEntity> findAllByStatus();

    @Query("select b from StCityEntity b where b.id=?1 and b.status=?2")
    StCityEntity findByIdAndByStatus(Long id, long status);
}
