package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTollsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StTollsRepository extends JpaRepository<StTollsEntity, Long> {
    @Query("select b from StTollsEntity b where b.status = 1 order by b.idTolls asc")
    List<StTollsEntity> findAllByStatus();

    @Query("select b from StTollsEntity b where b.idTolls=?1 and b.status=?2")
    StTollsEntity findByIdAndByStatus(Long id, long status);
}
