package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StFuelTypeService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StFuelTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuelTypes")
public class StFuelTypeController {
    @Autowired
    private StFuelTypeService stFuelTypeService;

    @GetMapping
    public List<StFuelTypeEntity> getAllFuelTypes() {
        return stFuelTypeService.getAllFuelTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StFuelTypeEntity> getFuelTypeById(@PathVariable int id) {
        return stFuelTypeService.getFuelTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StFuelTypeEntity createFuelType(@RequestBody StFuelTypeEntity fuelType) {
        return stFuelTypeService.createFuelType(fuelType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StFuelTypeEntity> updateFuelType(@PathVariable int id, @RequestBody StFuelTypeEntity fuelTypeDetails) {
        return ResponseEntity.ok(stFuelTypeService.updateFuelType(id, fuelTypeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelType(@PathVariable int id) {
        stFuelTypeService.deleteFuelType(id);
        return ResponseEntity.noContent().build();
    }
}
