package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StPersonService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class StPersonController {

    @Autowired
    private StPersonService stPersonService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StPersonEntity> getAllPersons() {
        return stPersonService.getAllPersons();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StPersonEntity> getPersonById(@PathVariable int id) {
        return stPersonService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StPersonEntity createPerson(@RequestBody StPersonEntity person) {
        return stPersonService.createPerson(person);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StPersonEntity> updatePerson(@PathVariable int id, @RequestBody StPersonEntity personDetails) {
        return ResponseEntity.ok(stPersonService.updatePerson(id, personDetails));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable int id) {
        stPersonService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }
}
