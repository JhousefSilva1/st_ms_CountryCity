package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository.StCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StCityService {
    @Autowired
    private StCityRepository stCityRepository;

    public List<StCityEntity> getAllCities() {
        return stCityRepository.findAllByStatus();
    }

    public Optional<StCityEntity> getCityById(Long id){
        return Optional.of(stCityRepository.findByIdAndByStatus(id, 1L));
    }

    public Optional<StCityEntity> createCity(StCityEntity stCityEntity){
        return Optional.of(stCityRepository.save(stCityEntity));
    }

    public Optional<StCityEntity> updateCity(Long id, StCityEntity stCityEntity){
        StCityEntity city = stCityRepository.findByIdAndByStatus(id, 1L);
        city.setCityName(stCityEntity.getCityName());
        city.setCountry(stCityEntity.getCountry());
        return Optional.of(stCityRepository.save(city));
    }

    public Optional<StCityEntity> deleteCity(Long id){
        StCityEntity city = stCityRepository.findByIdAndByStatus(id, 1L);
        city.setStatus(0);
        return Optional.of(stCityRepository.save(city));
    }
}
