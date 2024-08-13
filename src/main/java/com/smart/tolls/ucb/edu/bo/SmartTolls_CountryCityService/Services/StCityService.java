package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StCityRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StCityService {

    @Autowired
    private StCityRepository stCityRepository;

    public List<StCityEntity> getAllCities() {
        return stCityRepository.findAll();
    }

    public Optional<StCityEntity> getCityById(int id) {
        return stCityRepository.findById(id);
    }

    public StCityEntity createCity(StCityEntity city) {
        return stCityRepository.save(city);
    }

    public StCityEntity updateCity(int id, StCityEntity cityDetails) {
        StCityEntity city = stCityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
        city.setStCityId(cityDetails.getStCityId());
        city.setStCountryStCountryId(cityDetails.getStCountryStCountryId());
        // Update other fields as needed
        return stCityRepository.save(city);
    }

    public void deleteCity(int id) {
        stCityRepository.deleteById(id);
    }
}
