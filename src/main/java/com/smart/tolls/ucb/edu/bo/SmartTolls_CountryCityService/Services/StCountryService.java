package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StCountryRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
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

    public Optional<StCountryEntity> getCountryById(int id) {
        return stCountryRepository.findById(id);
    }

    public StCountryEntity createCountry(StCountryEntity country) {
        return stCountryRepository.save(country);
    }

    public StCountryEntity updateCountry(int id, StCountryEntity countryDetails) {
        StCountryEntity country = stCountryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setCountryName(countryDetails.getCountryName());
        // Update other fields as needed
        return stCountryRepository.save(country);
    }

    public void deleteCountry(int id) {
        stCountryRepository.deleteById(id);
    }
}
