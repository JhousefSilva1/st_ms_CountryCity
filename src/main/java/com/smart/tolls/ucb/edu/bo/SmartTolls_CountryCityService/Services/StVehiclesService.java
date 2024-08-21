package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StVehiclesRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehiclesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StVehiclesService {

    @Autowired
    private StVehiclesRepository stVehiclesRepository;

    public List<StVehiclesEntity> getAllVehicles() {
        return stVehiclesRepository.findAll();
    }

    public Optional<StVehiclesEntity> getVehicleById(int id) {
        return stVehiclesRepository.findById((long) id);
    }

    public StVehiclesEntity createVehicle(StVehiclesEntity vehicle) {
        return stVehiclesRepository.save(vehicle);
    }

    public StVehiclesEntity updateVehicle(int id, StVehiclesEntity vehicleDetails) {
        StVehiclesEntity vehicle = stVehiclesRepository.findById((long) id).orElseThrow(() -> new RuntimeException("Vehicle not found"));
        return stVehiclesRepository.save(vehicle);
    }

    public void deleteVehicle(int id) {
        stVehiclesRepository.deleteById((long) id);
    }
}
