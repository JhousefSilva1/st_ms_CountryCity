package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StPlacesService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
public class StPlacesController {

    @Autowired
    private StPlacesService stPlacesService;

    @GetMapping
    public List<StPlacesEntity> getAllPlaces() {
        return stPlacesService.getAllPlaces();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StPlacesEntity> getPlaceById(@PathVariable int id) {
        return stPlacesService.getPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StPlacesEntity createPlace(@RequestBody StPlacesEntity place) {
        return stPlacesService.createPlace(place);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StPlacesEntity> updatePlace(@PathVariable int id, @RequestBody StPlacesEntity placeDetails) {
        return ResponseEntity.ok(stPlacesService.updatePlace(id, placeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
        stPlacesService.deletePlace(id);
        return ResponseEntity.noContent().build();
    }
}
