package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StPersonTypeRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StPersonTypeService {

    @Autowired
    private StPersonTypeRepository stPersonTypeRepository;

    public List<StPersonTypeEntity> getAllPersonTypes() {
        return stPersonTypeRepository.findAll();
    }

    public Optional<StPersonTypeEntity> getPersonTypeById(int id) {
        return stPersonTypeRepository.findById(id);
    }

    public StPersonTypeEntity createPersonType(StPersonTypeEntity personType) {
        return stPersonTypeRepository.save(personType);
    }

    public StPersonTypeEntity updatePersonType(int id, StPersonTypeEntity personTypeDetails) {
        StPersonTypeEntity personType = stPersonTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("PersonType not found"));
        personType.setStPersonTypeId(personTypeDetails.getStPersonTypeId());
        personType.setStPersonType(personTypeDetails.getStPersonType());
        return stPersonTypeRepository.save(personType);
    }

    public void deletePersonType(int id) {
        stPersonTypeRepository.deleteById(id);
    }
}
