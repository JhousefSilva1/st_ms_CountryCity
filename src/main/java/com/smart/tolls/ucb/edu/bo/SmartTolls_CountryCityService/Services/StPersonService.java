package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StPersonRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StPersonService {

    @Autowired
    private StPersonRepository stPersonRepository;

    public List<StPersonEntity> getAllPersons() {
        return stPersonRepository.findAll();
    }

    public Optional<StPersonEntity> getPersonById(int id) {
        return stPersonRepository.findById(id);
    }

    public StPersonEntity createPerson(StPersonEntity person) {
        return stPersonRepository.save(person);
    }

    public StPersonEntity updatePerson(int id, StPersonEntity personDetails) {
        StPersonEntity person = stPersonRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));

        return stPersonRepository.save(person);
    }

    public void deletePerson(int id) {
        stPersonRepository.deleteById(id);
    }
}
