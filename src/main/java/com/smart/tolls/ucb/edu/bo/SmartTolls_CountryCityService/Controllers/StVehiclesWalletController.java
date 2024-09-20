package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StVehiclesWalletService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehiclesWalletEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles/wallet")
public class StVehiclesWalletController {

    @Autowired
    private StVehiclesWalletService stVehiclesWalletService;


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StVehiclesWalletEntity> getAllVehiclesWallet() {
        return stVehiclesWalletService.getAllVehiclesWallet();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public StVehiclesWalletEntity getVehiclesWalletById(@PathVariable int id) {
        return stVehiclesWalletService.getVehiclesWalletById(id).orElseThrow(() -> new RuntimeException("VehiclesWallet not found"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StVehiclesWalletEntity createVehiclesWallet(@RequestBody StVehiclesWalletEntity vehiclesWallet) {
        return stVehiclesWalletService.createVehiclesWallet(vehiclesWallet);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public StVehiclesWalletEntity updateVehiclesWallet(@PathVariable int id, @RequestBody StVehiclesWalletEntity vehiclesWalletDetails) {
        return stVehiclesWalletService.updateVehiclesWallet(id, vehiclesWalletDetails);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteVehiclesWallet(@PathVariable int id) {
        stVehiclesWalletService.deleteVehiclesWallet(id);
    }
}
