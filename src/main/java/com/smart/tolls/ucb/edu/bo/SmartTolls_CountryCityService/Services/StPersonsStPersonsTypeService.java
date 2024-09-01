//package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;
//
//import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StPersonsStPersonsTypeRepository;
//import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonsStPersonsTypeEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StPersonsStPersonsTypeService {
//
//    @Autowired
//    private StPersonsStPersonsTypeRepository stPersonsStPersonsTypeRepository;
//
//    public List<StPersonsStPersonsTypeEntity> getAllPersonsTypePerson() {
//        return stPersonsStPersonsTypeRepository.findAll();
//    }
//
//    public Optional<StPersonsStPersonsTypeEntity> getPersonTypePersonById(int id) {
//        return stPersonsStPersonsTypeRepository.findById((long) id);
//    }
//
//    public StPersonsStPersonsTypeEntity createPersonTypePerson(StPersonsStPersonsTypeEntity personTypePerson) {
//        return stPersonsStPersonsTypeRepository.save(personTypePerson);
//    }
//
//    public StPersonsStPersonsTypeEntity updatePersonTypePerson(int id, StPersonsStPersonsTypeEntity personTypePersonDetails) {
//        StPersonsStPersonsTypeEntity personTypePerson = stPersonsStPersonsTypeRepository.findById((long) id).orElseThrow(() -> new RuntimeException("Person not found"));
//
//        return stPersonsStPersonsTypeRepository.save(personTypePerson);
//    }
//
//    public void deletePersonTypePerson(int id) {
//        stPersonsStPersonsTypeRepository.deleteById((long) id);
//    }
//
//
//}
