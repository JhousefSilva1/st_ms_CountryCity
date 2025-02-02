package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository.StRoadTypeRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StRoadTypeService {
    @Autowired
    private StRoadTypeRepository stRoadTypeRepository;

    public List<StRoadTypeEntity> getAllRoadTypes() {
        return stRoadTypeRepository.findAll();
    }

    public List<StRoadTypeEntity> getAllRoadTypeByStatus() {
        return stRoadTypeRepository.findAllByStatus();
    }

    public Optional<StRoadTypeEntity> getRoadTypeById(Long id) {
        return Optional.of(stRoadTypeRepository.findByIdAndByStatus(id, 1L));
    }

    public Optional<StRoadTypeEntity> createRoadType(StRoadTypeEntity stRoadTypeEntity) {
        return Optional.of(stRoadTypeRepository.save(stRoadTypeEntity));
    }

    public Optional<StRoadTypeEntity> updateRoadType(Long id, StRoadTypeEntity stRoadTypeEntity) {
        StRoadTypeEntity roadType = stRoadTypeRepository.findByIdAndByStatus(id, 1L);
        roadType.setRoadType(stRoadTypeEntity.getRoadType());
        return Optional.of(stRoadTypeRepository.save(roadType));
    }

    public Optional<StRoadTypeEntity> deleteRoadType(Long id) {
        StRoadTypeEntity roadType = stRoadTypeRepository.findByIdAndByStatus(id, 1L);
        roadType.setStatus(0);
        return Optional.of(stRoadTypeRepository.save(roadType));
    }

    public boolean isServiceAvailable() {
        try {
            stRoadTypeRepository.count();
            return true;
        } catch (Exception e) {
            LoggerFactory.getLogger(StTollsService.class).error("Database is not available", e);
            return false;
        }
    }
}
