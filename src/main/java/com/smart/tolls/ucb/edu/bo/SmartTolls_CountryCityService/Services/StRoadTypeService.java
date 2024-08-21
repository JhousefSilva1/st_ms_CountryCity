package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StRoadTypeRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StRoadTypeService {

    @Autowired
    private StRoadTypeRepository stRoadTypeRepository;

    public List<StRoadTypeEntity> getAllRoadTypes() {
        return stRoadTypeRepository.findAll();
    }

    public Optional<StRoadTypeEntity> getRoadTypeById(int id) {
        return stRoadTypeRepository.findById((long) id);
    }

    public StRoadTypeEntity createRoadType(StRoadTypeEntity roadType) {
        return stRoadTypeRepository.save(roadType);
    }

    public Optional<StRoadTypeEntity> updateRoadType(int id, StRoadTypeEntity roadTypeDetails) {
        StRoadTypeEntity roadType = stRoadTypeRepository.findById((long) id).

                orElseThrow(() -> new RuntimeException("Road type not found"));
//        roadType.setStRoadTypeId(roadTypeDetails.getStRoadTypeId());
//        roadType.setStRoadTypeName(roadTypeDetails.getStRoadTypeName());
        // Update other fields as needed
        return Optional.of(stRoadTypeRepository.save(roadType));
    }

    public void deleteRoadType(int id) {
        stRoadTypeRepository.deleteById((long) id);
    }

}
