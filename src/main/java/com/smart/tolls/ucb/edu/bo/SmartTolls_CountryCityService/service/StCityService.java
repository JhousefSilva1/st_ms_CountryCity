package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository.StCityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StCityService {
    @Autowired
    private StCityRepository stCityRepository;

    public List<StCityEntity> getAllCities() {
        return stCityRepository.findAll();
    }

    public StCityEntity getCityById(Long id){
        return stCityRepository.findById(id).get();
    }

    public StCityEntity createCity(StCityEntity stCityEntity){
        return stCityRepository.save(stCityEntity);
    }

    public StCityEntity updateCity(Long id, StCityEntity stCityEntity){
        StCityEntity city = stCityRepository.findById(id).orElseThrow(()-> new RuntimeException("City not found")) ;
        city.setCityName(stCityEntity.getCityName());
        return stCityRepository.save(city);
    }

    public void deleteCity(Long id){
        stCityRepository.deleteById(id);
    }
}
