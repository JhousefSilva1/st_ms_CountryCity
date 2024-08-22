package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;


import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StLinesRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StLinesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StLinesService {

    @Autowired
    private StLinesRepository stLinesRepository;

    public List<StLinesEntity> getAllLines() {
        return stLinesRepository.findAll();
    }

    public Optional<StLinesEntity> getLinesById(int id) {
        return stLinesRepository.findById((long) id);
    }

    public StLinesEntity createLines(StLinesEntity lines) {
        return stLinesRepository.save(lines);
    }

    public Optional<StLinesEntity> updateLines(int id, StLinesEntity linesDetails) {
        StLinesEntity lines = stLinesRepository.findById((long) id).orElseThrow(() -> new RuntimeException("Lines not found"));
        return Optional.of(stLinesRepository.save(lines));
    }

    public void deleteLines(int id) {
        stLinesRepository.deleteById((long) id);
    }


}
