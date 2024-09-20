package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StCountryService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class StCountryController {

    @Autowired
    private StCountryService stCountryService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StCountryEntity> getAllCountries() {
        return stCountryService.getAllCountries();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StCountryEntity> getCountryById(@PathVariable int id) {
        return stCountryService.getCountryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StCountryEntity createCountry(@RequestBody StCountryEntity country) {
        return stCountryService.createCountry(country);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StCountryEntity> updateCountry(@PathVariable int id, @RequestBody StCountryEntity countryDetails) {
        return ResponseEntity.ok(stCountryService.updateCountry(id, countryDetails));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable int id) {
        stCountryService.deleteCountry(id);
        // Devuelve un código 200 con un mensaje opcional
        return ResponseEntity.ok("Country was deleted successfully");
    }
}
