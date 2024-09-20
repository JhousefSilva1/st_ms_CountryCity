package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Controllers;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services.StLinesService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StLinesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tolls/lines")
public class StLinesController {

    @Autowired
    private StLinesService stLinesService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping
    public List<StLinesEntity> getAllLines() {
        return stLinesService.getAllLines();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('EMPLOYEE')")
    @GetMapping("/{id}")
    public Optional<StLinesEntity> getLineById(@PathVariable int id) {
        return stLinesService.getLinesById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public StLinesEntity createLine(@RequestBody StLinesEntity line) {
        return stLinesService.createLines(line);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Optional<StLinesEntity> updateLine(@PathVariable int id, @RequestBody StLinesEntity lineDetails) {
        return stLinesService.updateLines(id, lineDetails);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteLine(@PathVariable int id) {
        stLinesService.deleteLines(id);
    }
}
