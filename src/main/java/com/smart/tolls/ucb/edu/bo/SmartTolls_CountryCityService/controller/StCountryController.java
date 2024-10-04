package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/country")
public class StCountryController {

    @Autowired
    private StCountryService stCountryService;

    @GetMapping
    public List<StCountryEntity> getAllCountries(){
        return stCountryService.getAllCountries();
    }
    @GetMapping("/{id}")
    public StCountryEntity getCountryById(@PathVariable  Long id){
        Optional<StCountryEntity> country = stCountryService.getCountryById(id);

        return country.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()).getBody();
    }

    @PostMapping
    public StCountryEntity createCountry(@RequestBody StCountryEntity stCountryEntity){
        return stCountryService.createCountry(stCountryEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StCountryEntity> updateCountry(@PathVariable Long id, @RequestBody StCountryEntity stCountryEntity){
        return ResponseEntity.ok(stCountryService.updateCountry(id, stCountryEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <String> deleteCountry(@PathVariable Long id){
        stCountryService.deleteCountry(id);
        return ResponseEntity.ok("Pais eliminado correctamente");
    }

}
