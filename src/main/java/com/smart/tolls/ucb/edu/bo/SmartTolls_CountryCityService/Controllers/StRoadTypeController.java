package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StRoadTypeService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/road-types")
public class StRoadTypeController {

    @Autowired
    private StRoadTypeService stRoadTypeService;

    @GetMapping
    public List<StRoadTypeEntity> getAllRoadTypes() {
        return stRoadTypeService.getAllRoadTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StRoadTypeEntity> getRoadTypeById(@PathVariable int id) {
        return ResponseEntity.of(stRoadTypeService.getRoadTypeById(id));
    }

    @PostMapping
    public StRoadTypeEntity createRoadType(@RequestBody StRoadTypeEntity roadType) {
        return stRoadTypeService.createRoadType(roadType);
    }

    @PutMapping("/{id}")
    public Optional<StRoadTypeEntity> updateRoadType(@PathVariable int id, @RequestBody StRoadTypeEntity roadTypeDetails) {
        return stRoadTypeService.updateRoadType(id, roadTypeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteRoadType(@PathVariable int id) {
        stRoadTypeService.deleteRoadType(id);
    }

}
