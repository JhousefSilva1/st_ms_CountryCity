package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StRoadTypeService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/road-types")
public class StRoadTypeController {

    @Autowired
    private StRoadTypeService stRoadTypeService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StRoadTypeEntity> getAllRoadTypes() {
        return stRoadTypeService.getAllRoadTypes();
    }


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StRoadTypeEntity> getRoadTypeById(@PathVariable int id) {
        return ResponseEntity.of(stRoadTypeService.getRoadTypeById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StRoadTypeEntity createRoadType(@RequestBody StRoadTypeEntity roadType) {
        return stRoadTypeService.createRoadType(roadType);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Optional<StRoadTypeEntity> updateRoadType(@PathVariable int id, @RequestBody StRoadTypeEntity roadTypeDetails) {
        return stRoadTypeService.updateRoadType(id, roadTypeDetails);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteRoadType(@PathVariable int id) {
        stRoadTypeService.deleteRoadType(id);
    }

}
