package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StVehiclesTypeRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehiclesTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StVehiclesTypeService {

    @Autowired
    private StVehiclesTypeRepository stVehiclesTypeRepository;

    public List<StVehiclesTypeEntity> getAllVehiclesType() {
        return stVehiclesTypeRepository.findAll();
    }

    public Optional<StVehiclesTypeEntity>getVehiclesTypeById(int id){
        return stVehiclesTypeRepository.findById((long) id);
    }

    public StVehiclesTypeEntity createVehiclesType(StVehiclesTypeEntity vehiclesType){
        return stVehiclesTypeRepository.save(vehiclesType);
    }

    public StVehiclesTypeEntity updateVehiclesType(int id, StVehiclesTypeEntity vehiclesTypeDetails) {
        StVehiclesTypeEntity vehiclesType = stVehiclesTypeRepository.findById((long) id).orElseThrow(() -> new RuntimeException("VehiclesType not found"));
        vehiclesType.setVehicleType(vehiclesTypeDetails.getVehicleType());
        vehiclesType.setId(vehiclesTypeDetails.getId());
        return stVehiclesTypeRepository.save(vehiclesType);
    }

    public void deleteVehiclesType(int id) {
        stVehiclesTypeRepository.deleteById((long) id);
    }
}
