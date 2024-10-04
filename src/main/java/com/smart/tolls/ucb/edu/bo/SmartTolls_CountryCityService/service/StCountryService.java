package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository.StCountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StCountryService {
    @Autowired
    private StCountryRepository stCountryRepository;

    public List<StCountryEntity> getAllCountries() {
        return stCountryRepository.findAll();
    }

    public Optional<StCountryEntity> getCountryById(Long id) {
        return Optional.of(stCountryRepository.findById(id).get());
    }

    public StCountryEntity createCountry(StCountryEntity stCountryEntity) {
        return stCountryRepository.save(stCountryEntity);
    }

    public  StCountryEntity updateCountry(Long id, StCountryEntity countryDetails) {
        StCountryEntity country = stCountryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setCountryName( countryDetails.getCountryName());
        return stCountryRepository.save(country);
    }

    public void deleteCountry(Long id) {
        stCountryRepository.deleteById(id);
    }

}
