package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StGenderService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StGenderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gender")
public class StGenderController {
    @Autowired
    private StGenderService stGenderService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StGenderEntity> getAllGenders(){
        return stGenderService.getAllGenders();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public ResponseEntity<StGenderEntity> getGenderById(@PathVariable int id) {
        return stGenderService.getGenderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StGenderEntity createGender(@RequestBody StGenderEntity gender){
        return stGenderService.createGender(gender);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StGenderEntity> updateGender(@PathVariable int id, @RequestBody StGenderEntity genderDetails) {
        return ResponseEntity.ok(stGenderService.updateGender(id, genderDetails));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGender(@PathVariable int id) {
        stGenderService.deleteGender(id);
        // Devuelve un código 200 con un mensaje opcional
        return ResponseEntity.ok("Gender was deleted successfully");
    }
}
