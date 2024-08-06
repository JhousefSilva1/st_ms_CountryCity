package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StCityRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StCityService {

    @Autowired
    private StCityRepository stCityRepository;

    public List<StCity> getAllCities() {
        return stCityRepository.findAll();
    }

    public Optional<StCity> getCityById(int id) {
        return stCityRepository.findById(id);
    }

    public StCity createCity(StCity city) {
        return stCityRepository.save(city);
    }

    public StCity updateCity(int id, StCity cityDetails) {
        StCity city = stCityRepository.findById(id).orElseThrow(() -> new RuntimeException("City not found"));
        city.setCity(cityDetails.getCity());
        city.setCountryId(cityDetails.getCountryId());
        // Update other fields as needed
        return stCityRepository.save(city);
    }

    public void deleteCity(int id) {
        stCityRepository.deleteById(id);
    }
}
