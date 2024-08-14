package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StPersonService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class StPersonController {

    @Autowired
    private StPersonService stPersonService;

    @GetMapping
    public List<StPersonEntity> getAllPersons() {
        return stPersonService.getAllPersons();
    }
    @GetMapping("/{id}")
    public ResponseEntity<StPersonEntity> getPersonById(@PathVariable int id) {
        return stPersonService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public StPersonEntity createPerson(@RequestBody StPersonEntity person) {
        return stPersonService.createPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StPersonEntity> updatePerson(@PathVariable int id, @RequestBody StPersonEntity personDetails) {
        return ResponseEntity.ok(stPersonService.updatePerson(id, personDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        stPersonService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
