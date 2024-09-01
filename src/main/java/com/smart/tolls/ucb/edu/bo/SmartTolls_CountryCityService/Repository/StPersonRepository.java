package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StPersonRepository extends JpaRepository<StPersonEntity, Integer> {
    Optional<StPersonEntity> findByEmail(String email);
}
