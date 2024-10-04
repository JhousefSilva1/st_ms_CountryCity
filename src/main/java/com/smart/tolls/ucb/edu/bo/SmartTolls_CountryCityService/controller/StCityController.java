package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class StCityController {
    @Autowired
    private StCityService stCityService;

//    @GetMapping
//    public List<StCityEntity> getAllCities(){
//        return stCityService.getAllCities();
//    }

    @GetMapping
    public ResponseEntity<List<StCityEntity>> getAllCities(){
        return ResponseEntity.ok(stCityService.getAllCities());
    }
    @GetMapping("/{id}")
    public StCityEntity getCityById(@PathVariable Long id){
        return stCityService.getCityById(id);
    }

    @PostMapping
    public StCityEntity createCity(@RequestBody StCityEntity stCityEntity){
        return stCityService.createCity(stCityEntity);
    }

    @PutMapping("/{id}")
    public StCityEntity updateCity(@PathVariable Long id, @RequestBody StCityEntity stCityEntity){
        return stCityService.updateCity(id, stCityEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id){

        stCityService.deleteCity(id);
        return ResponseEntity.ok("Ciudad eliminada correctamente");
    }
}
