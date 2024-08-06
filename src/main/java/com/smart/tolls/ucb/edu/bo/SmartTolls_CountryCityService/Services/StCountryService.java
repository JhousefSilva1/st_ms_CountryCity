package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StCountryRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StCountryService {

    @Autowired
    private StCountryRepository stCountryRepository;

    public List<StCountry> getAllCountries() {
        return stCountryRepository.findAll();
    }

    public Optional<StCountry> getCountryById(int id) {
        return stCountryRepository.findById(id);
    }

    public StCountry createCountry(StCountry country) {
        return stCountryRepository.save(country);
    }

    public StCountry updateCountry(int id, StCountry countryDetails) {
        StCountry country = stCountryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
        country.setCountryName(countryDetails.getCountryName());
        // Update other fields as needed
        return stCountryRepository.save(country);
    }

    public void deleteCountry(int id) {
        stCountryRepository.deleteById(id);
    }
}
