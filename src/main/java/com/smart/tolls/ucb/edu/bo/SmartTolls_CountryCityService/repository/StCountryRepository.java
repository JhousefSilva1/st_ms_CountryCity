package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StCountryRepository extends JpaRepository<StCountryEntity, Long> {
    @Query("select b from StCountryEntity b where b.status = 1 order by b.idCountry asc")
    List<StCountryEntity> findAllByStatus();

    @Query("select b from StCountryEntity b where b.idCountry=?1 and b.status=?2")
    StCountryEntity findByIdAndByStatus(Long id, long status);
}
