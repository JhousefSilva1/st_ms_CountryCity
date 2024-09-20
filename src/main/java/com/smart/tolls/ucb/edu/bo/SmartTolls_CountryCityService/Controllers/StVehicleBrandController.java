package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StVehicleBrandService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehicleBrandsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicleBrands")
public class StVehicleBrandController {

    @Autowired
    private StVehicleBrandService stVehicleBrandService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StVehicleBrandsEntity> getAllVehicleBrands() {
        return stVehicleBrandService.getAllVehicleBrands();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StVehicleBrandsEntity> getVehicleBrandById(@PathVariable int id) {
        return stVehicleBrandService.getVehicleBrandById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StVehicleBrandsEntity createVehicleBrand(@RequestBody StVehicleBrandsEntity vehicleBrand) {
        return stVehicleBrandService.createVehicleBrand(vehicleBrand);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StVehicleBrandsEntity> updateVehicleBrand(@PathVariable int id, @RequestBody StVehicleBrandsEntity vehicleBrandDetails) {
        return ResponseEntity.ok(stVehicleBrandService.updateVehicleBrand(id, vehicleBrandDetails));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicleBrand(@PathVariable int id) {
        stVehicleBrandService.deleteVehicleBrand(id);
        return ResponseEntity.noContent().build();
    }
}
