package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StFuelTypeService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StFuelTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fuelTypes")
public class StFuelTypeController {
    @Autowired
    private StFuelTypeService stFuelTypeService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StFuelTypeEntity> getAllFuelTypes() {
        return stFuelTypeService.getAllFuelTypes();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StFuelTypeEntity> getFuelTypeById(@PathVariable int id) {
        return stFuelTypeService.getFuelTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StFuelTypeEntity createFuelType(@RequestBody StFuelTypeEntity fuelType) {
        return stFuelTypeService.createFuelType(fuelType);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StFuelTypeEntity> updateFuelType(@PathVariable int id, @RequestBody StFuelTypeEntity fuelTypeDetails) {
        return ResponseEntity.ok(stFuelTypeService.updateFuelType(id, fuelTypeDetails));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuelType(@PathVariable int id) {
        stFuelTypeService.deleteFuelType(id);
        return ResponseEntity.noContent().build();
    }
}
