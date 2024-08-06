package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StCityService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCity;
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
    public List<StCity> getAllCities() {
        return stCityService.getAllCities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StCity> getCityById(@PathVariable int id) {
        return stCityService.getCityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StCity createCity(@RequestBody StCity city) {
        return stCityService.createCity(city);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StCity> updateCity(@PathVariable int id, @RequestBody StCity cityDetails) {
        return ResponseEntity.ok(stCityService.updateCity(id, cityDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable int id) {
        stCityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}
