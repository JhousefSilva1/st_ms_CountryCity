package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StPlacesRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StPlacesService {

    @Autowired
    private StPlacesRepository stPlacesRepository;

    public List<StPlacesEntity> getAllPlaces() {
        return stPlacesRepository.findAll();
    }

    public Optional<StPlacesEntity> getPlaceById(int id) {
        return stPlacesRepository.findById((long) id);
    }

    public StPlacesEntity createPlace(StPlacesEntity place) {
        return stPlacesRepository.save(place);
    }

    public StPlacesEntity updatePlace(int id, StPlacesEntity placeDetails) {
        StPlacesEntity place = stPlacesRepository.findById((long) id).orElseThrow(() -> new RuntimeException("Place not found"));
        place.setStPlacesId(placeDetails.getStPlacesId());
        place.setStCityStCityId(placeDetails.getStCityStCityId());
        // Update other fields as needed
        return stPlacesRepository.save(place);
    }

    public void deletePlace(int id) {
        stPlacesRepository.deleteById((long) id);
    }
}
