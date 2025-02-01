package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTollsEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository.StTollsRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StTollsService {
    @Autowired
    private StTollsRepository stTollsRepository;

    public List<StTollsEntity> getAllTolls(){
        return stTollsRepository.findAll();
    }

    public List<StTollsEntity> getAllTollsByStatus(){
        return stTollsRepository.findAllByStatus();
    }

    public Optional<StTollsEntity> getTollsById(Long id){
        return Optional.of(stTollsRepository.findByIdAndByStatus(id, 1L));
    }

    public Optional<StTollsEntity> createTolls(StTollsEntity stTollsEntity){
        return Optional.of(stTollsRepository.save(stTollsEntity));
    }

    public Optional<StTollsEntity> updateTolls(Long id, StTollsEntity stTollsEntity){
        StTollsEntity tolls = stTollsRepository.findByIdAndByStatus(id, 1L);
        tolls.setTollsName(stTollsEntity.getTollsName());
        return Optional.of(stTollsRepository.save(tolls));
    }

    public Optional<StTollsEntity> deleteTolls(Long id){
        StTollsEntity tolls = stTollsRepository.findByIdAndByStatus(id, 1L);
        tolls.setStatus(0);
        return Optional.of(stTollsRepository.save(tolls));
    }

    public boolean isServiceAvailable() {
        try {
            stTollsRepository.count();
            return true;
        } catch (Exception e) {
            LoggerFactory.getLogger(StTollsService.class).error("Database is not available", e);
            return false;
        }
    }
}
