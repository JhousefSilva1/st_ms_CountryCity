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
        return stCountryRepository.findAllByStatus();
    }

    public Optional<StCountryEntity> getCountryById(Long id) {
        return Optional.of(stCountryRepository.findByIdAndByStatus(id, 1L));
    }

    public Optional<StCountryEntity> createCountry(StCountryEntity stCountryEntity) {
        StCountryEntity stCountry = new StCountryEntity();
        stCountry.setCountryName(stCountryEntity.getCountryName());
        return Optional.of(stCountryRepository.save(stCountry));
    }

    public Optional<StCountryEntity> updateCountry(Long id, StCountryEntity countryDetails) {
        StCountryEntity country = stCountryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setCountryName(countryDetails.getCountryName());
        return Optional.of(stCountryRepository.save(country));
    }

    public Optional<StCountryEntity> deleteCountry(Long id) {
        StCountryEntity country = stCountryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setStatus(0);
        return Optional.of(stCountryRepository.save(country));
    }

}
