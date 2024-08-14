package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StVehicleBrandService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehicleBrandsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicleBrands")
public class StVehicleBrandController {
    @Autowired
    private StVehicleBrandService stVehicleBrandService;

    @GetMapping
    public List<StVehicleBrandsEntity> getAllVehicleBrands() {
        return stVehicleBrandService.getAllVehicleBrands();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StVehicleBrandsEntity> getVehicleBrandById(@PathVariable int id) {
        return stVehicleBrandService.getVehicleBrandById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StVehicleBrandsEntity createVehicleBrand(@RequestBody StVehicleBrandsEntity vehicleBrand) {
        return stVehicleBrandService.createVehicleBrand(vehicleBrand);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StVehicleBrandsEntity> updateVehicleBrand(@PathVariable int id, @RequestBody StVehicleBrandsEntity vehicleBrandDetails) {
        return ResponseEntity.ok(stVehicleBrandService.updateVehicleBrand(id, vehicleBrandDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleBrand(@PathVariable int id) {
        stVehicleBrandService.deleteVehicleBrand(id);
        return ResponseEntity.noContent().build();
    }
}
