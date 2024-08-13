package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StFuelTypeRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StFuelTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StFuelTypeService {
    @Autowired
    private StFuelTypeRepository stFuelTypeRepository;

    public List<StFuelTypeEntity> getAllFuelTypes() {
        return stFuelTypeRepository.findAll();
    }

    public Optional<StFuelTypeEntity> getFuelTypeById(int id) {
        return stFuelTypeRepository.findById(id);
    }

    public StFuelTypeEntity createFuelType(StFuelTypeEntity fuelType) {
        return stFuelTypeRepository.save(fuelType);
    }

    public StFuelTypeEntity updateFuelType(int id, StFuelTypeEntity fuelTypeDetails) {
        StFuelTypeEntity fuelType = stFuelTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Fuel type not found"));
        fuelType.setFuelType(fuelTypeDetails.getFuelType());
        // Update other fields as needed
        return stFuelTypeRepository.save(fuelType);
    }

    public void deleteFuelType(int id) {
        stFuelTypeRepository.deleteById(id);
    }
}
