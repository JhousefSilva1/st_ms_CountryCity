package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StTollsService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTollsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tolls")
public class StTollsController {

    @Autowired
    private StTollsService stTollsService;


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StTollsEntity> getAllTolls() {
        return stTollsService.getAllTolls();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public Optional<StTollsEntity> getTollById(@PathVariable int id) {
        return stTollsService.getTollsById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StTollsEntity createToll(@RequestBody StTollsEntity toll) {
        return stTollsService.createTolls(toll);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Optional<StTollsEntity> updateToll(@PathVariable int id, @RequestBody StTollsEntity tollDetails) {
        return stTollsService.updateTolls(id, tollDetails);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteToll(@PathVariable int id) {
        stTollsService.deleteTolls(id);
    }
}
