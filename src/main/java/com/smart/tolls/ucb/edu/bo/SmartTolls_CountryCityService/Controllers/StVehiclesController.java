package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StVehiclesService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehiclesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class StVehiclesController {

    @Autowired
    private StVehiclesService stVehiclesService;

    @GetMapping
    public List<StVehiclesEntity> getAllVehicles() {
        return stVehiclesService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StVehiclesEntity> getVehicleById(@PathVariable int id) {
        return stVehiclesService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StVehiclesEntity createVehicle(@RequestBody StVehiclesEntity vehicle) {
        return stVehiclesService.createVehicle(vehicle);
    }

    @PostMapping("/{id}")
    public ResponseEntity<StVehiclesEntity> updateVehicle(@PathVariable int id, @RequestBody StVehiclesEntity vehicleDetails) {
        return ResponseEntity.ok(stVehiclesService.updateVehicle(id, vehicleDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable int id) {
        stVehiclesService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }


}
