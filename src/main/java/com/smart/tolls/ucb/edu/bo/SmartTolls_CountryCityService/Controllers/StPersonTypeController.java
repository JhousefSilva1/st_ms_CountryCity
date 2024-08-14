package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StPersonTypeService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personTypes")
public class StPersonTypeController {

    @Autowired
    private StPersonTypeService stPersonTypeService;

    @GetMapping
    public List<StPersonTypeEntity> getAllPersonTypes() {
        return stPersonTypeService.getAllPersonTypes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StPersonTypeEntity> getPersonTypeById(@PathVariable int id) {
        return stPersonTypeService.getPersonTypeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StPersonTypeEntity createPersonType(@RequestBody StPersonTypeEntity personType) {
        return stPersonTypeService.createPersonType(personType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StPersonTypeEntity> updatePersonType(@PathVariable int id, @RequestBody StPersonTypeEntity personTypeDetails) {
        return ResponseEntity.ok(stPersonTypeService.updatePersonType(id, personTypeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonType(@PathVariable int id) {
        stPersonTypeService.deletePersonType(id);
        return ResponseEntity.noContent().build();
    }
}
