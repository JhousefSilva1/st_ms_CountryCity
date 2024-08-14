package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StVehicleBrandRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehicleBrandsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StVehicleBrandService {
    @Autowired
    private StVehicleBrandRepository stVehicleBrandRepository;

    public List<StVehicleBrandsEntity> getAllVehicleBrands() {
        return stVehicleBrandRepository.findAll();
    }

    public Optional<StVehicleBrandsEntity> getVehicleBrandById(int id) {
        return stVehicleBrandRepository.findById(id);
    }

    public StVehicleBrandsEntity createVehicleBrand(StVehicleBrandsEntity vehicleBrand) {
        return stVehicleBrandRepository.save(vehicleBrand);
    }

    public StVehicleBrandsEntity updateVehicleBrand(int id, StVehicleBrandsEntity vehicleBrandDetails) {
        StVehicleBrandsEntity vehicleBrand = stVehicleBrandRepository.findById(id).orElseThrow(() -> new RuntimeException("Vehicle brand not found"));
        vehicleBrand.setVehicleBrand(vehicleBrandDetails.getVehicleBrand());
        // Update other fields as needed
        return stVehicleBrandRepository.save(vehicleBrand);
    }

    public void deleteVehicleBrand(int id) {
        stVehicleBrandRepository.deleteById(id);
    }
}
