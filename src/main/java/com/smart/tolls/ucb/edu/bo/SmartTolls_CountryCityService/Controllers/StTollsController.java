package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StTollsService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTollsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tolls")
public class StTollsController {

    @Autowired
    private StTollsService stTollsService;

    @GetMapping
    public List<StTollsEntity> getAllTolls() {
        return stTollsService.getAllTolls();
    }

    @GetMapping("/{id}")
    public Optional<StTollsEntity> getTollById(@PathVariable int id) {
        return stTollsService.getTollsById(id);
    }

    @PostMapping
    public StTollsEntity createToll(@RequestBody StTollsEntity toll) {
        return stTollsService.createTolls(toll);
    }

    @PutMapping("/{id}")
    public Optional<StTollsEntity> updateToll(@PathVariable int id, @RequestBody StTollsEntity tollDetails) {
        return stTollsService.updateTolls(id, tollDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteToll(@PathVariable int id) {
        stTollsService.deleteTolls(id);
    }
}
