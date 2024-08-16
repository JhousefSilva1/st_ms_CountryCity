package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StVehiclesModelsRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehicleModelsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StVehiclesModelsService {

    @Autowired
    private StVehiclesModelsRepository stVehiclesModelsRepository;

    public List<StVehicleModelsEntity> getAllVehiclesModels() {
        return stVehiclesModelsRepository.findAll();
    }

    public Optional<StVehicleModelsEntity> getVehiclesModelsById(int id) {
        return stVehiclesModelsRepository.findById((long) id);
    }

    public StVehicleModelsEntity createVehiclesModels(StVehicleModelsEntity vehiclesModels) {
        return stVehiclesModelsRepository.save(vehiclesModels);
    }

    public StVehicleModelsEntity updateVehiclesModels(int id, StVehicleModelsEntity vehiclesModelsDetails) {
        StVehicleModelsEntity vehiclesModels = stVehiclesModelsRepository.findById((long) id).orElseThrow(() -> new RuntimeException("VehiclesModels not found"));
        vehiclesModels.setVehicleModel(vehiclesModelsDetails.getVehicleModel());
        vehiclesModels.setId(vehiclesModelsDetails.getId());
        return stVehiclesModelsRepository.save(vehiclesModels);

    }

    public void deleteVehiclesModels(int id) {
        stVehiclesModelsRepository.deleteById((long) id);
    }


}

