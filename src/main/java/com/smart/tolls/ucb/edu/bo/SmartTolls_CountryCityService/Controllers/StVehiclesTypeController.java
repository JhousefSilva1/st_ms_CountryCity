package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StVehiclesTypeService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehiclesTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/type")
public class StVehiclesTypeController {

    @Autowired
    private StVehiclesTypeService stVehiclesTypeService;


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StVehiclesTypeEntity> getAllVehiclesType() {
        return stVehiclesTypeService.getAllVehiclesType();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StVehiclesTypeEntity> getVehiclesTypeById(@PathVariable int id) {
        return stVehiclesTypeService.getVehiclesTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StVehiclesTypeEntity createVehiclesType(@RequestBody StVehiclesTypeEntity vehiclesType) {
        return stVehiclesTypeService.createVehiclesType(vehiclesType);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StVehiclesTypeEntity> updateVehiclesType(@PathVariable int id, @RequestBody StVehiclesTypeEntity vehiclesTypeDetails) {
        return ResponseEntity.ok(stVehiclesTypeService.updateVehiclesType(id, vehiclesTypeDetails));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiclesType(@PathVariable int id) {
        stVehiclesTypeService.deleteVehiclesType(id);
        return ResponseEntity.noContent().build();
    }

}
