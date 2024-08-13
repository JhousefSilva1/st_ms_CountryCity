package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StGenderRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StGenderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StGenderService {

    @Autowired
    private StGenderRepository stGenderRepository;

    public List<StGenderEntity> getAllGenders(){
        return stGenderRepository.findAll();
    }

    public Optional<StGenderEntity> getGenderById(int id) {
        return stGenderRepository.findById(id);
    }

    public StGenderEntity createGender(StGenderEntity gender) {
        return stGenderRepository.save(gender);
    }

    public StGenderEntity updateGender(int id, StGenderEntity genderDetails) {
        StGenderEntity gender = stGenderRepository.findById(id).orElseThrow(() -> new RuntimeException("Geneder not found"));
        // Update other fields as needed
        return stGenderRepository.save(gender);
    }
    public void deleteGender(int id) {
        stGenderRepository.deleteById(id);
    }
}
