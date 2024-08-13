package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StCityService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class StCityController {

    @Autowired
    private StCityService stCityService;

    @GetMapping
    public List<StCityEntity> getAllCities() {
        return stCityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StCityEntity> getCityById(@PathVariable int id) {
        return stCityService.getCityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StCityEntity createCity(@RequestBody StCityEntity city) {
        return stCityService.createCity(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StCityEntity> updateCity(@PathVariable int id, @RequestBody StCityEntity cityDetails) {
        return ResponseEntity.ok(stCityService.updateCity(id, cityDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable int id) {
        stCityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
