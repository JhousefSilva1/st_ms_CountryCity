package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.repository.StPlacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StPlacesService {

    @Autowired
    private StPlacesRepository stPlacesRepository;

    //getAllPlaces
    public List<StPlacesEntity> getAllPlaces() {
        return stPlacesRepository.findAll();
    }

    //getPlacesById
    public Optional<StPlacesEntity> getPlaceById(Long id){
        return Optional.of(stPlacesRepository.findByIdAndByStatus(id, 1L));
    }

    //getAllPlacesByStatus
    public List<StPlacesEntity>getAllPlacesByStatus(){
        return stPlacesRepository.findAllByStatus();
    }


    public Optional<StPlacesEntity> createPlaces(StPlacesEntity stPlacesEntity){
        return Optional.of(stPlacesRepository.save(stPlacesEntity));
    }
    public Optional<StPlacesEntity> updatePlaces(Long id, StPlacesEntity placesDetails){
        StPlacesEntity places = stPlacesRepository.findById(id).orElseThrow(() -> new RuntimeException("Place not found"));
        places.setPlaceName(placesDetails.getPlaceName());
        return Optional.of(stPlacesRepository.save(places));
    }
    public Optional<StPlacesEntity> deletePlaces(Long id){
        StPlacesEntity places = stPlacesRepository.findById(id).orElseThrow(()-> new RuntimeException("Place not found"));
        places.setStatus(0);
        return Optional.of(stPlacesRepository.save(places));
    }

}
