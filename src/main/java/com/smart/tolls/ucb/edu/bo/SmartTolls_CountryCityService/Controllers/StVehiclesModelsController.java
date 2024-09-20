package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StVehiclesModelsService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehicleModelsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/models")
public class StVehiclesModelsController {

    @Autowired
    private StVehiclesModelsService stVehiclesModelsService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StVehicleModelsEntity> getAllVehiclesModels() {
        return stVehiclesModelsService.getAllVehiclesModels();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StVehicleModelsEntity> getVehiclesModelsById(@PathVariable int id) {
        return stVehiclesModelsService.getVehiclesModelsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StVehicleModelsEntity createVehiclesModels(@RequestBody StVehicleModelsEntity vehiclesModels) {
        return stVehiclesModelsService.createVehiclesModels(vehiclesModels);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StVehicleModelsEntity> updateVehiclesModels(@PathVariable int id, @RequestBody StVehicleModelsEntity vehiclesModelsDetails) {
        return ResponseEntity.ok(stVehiclesModelsService.updateVehiclesModels(id, vehiclesModelsDetails));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiclesModels(@PathVariable int id) {
        stVehiclesModelsService.deleteVehiclesModels(id);
        return ResponseEntity.noContent().build();
    }
}
