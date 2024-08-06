package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StCountryService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class StCountryController {

    @Autowired
    private StCountryService stCountryService;

    @GetMapping
    public List<StCountry> getAllCountries() {
        return stCountryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StCountry> getCountryById(@PathVariable int id) {
        return stCountryService.getCountryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StCountry createCountry(@RequestBody StCountry country) {
        return stCountryService.createCountry(country);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StCountry> updateCountry(@PathVariable int id, @RequestBody StCountry countryDetails) {
        return ResponseEntity.ok(stCountryService.updateCountry(id, countryDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable int id) {
        stCountryService.deleteCountry(id);
        // Devuelve un código 200 con un mensaje opcional
        return ResponseEntity.ok("Country deleted successfully");
    }
}
