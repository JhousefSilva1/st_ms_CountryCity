package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StTollsRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTollsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StTollsService {

    @Autowired
    private StTollsRepository stTollsRepository;

    public List<StTollsEntity> getAllTolls() {
        return stTollsRepository.findAll();
    }

    public Optional<StTollsEntity> getTollsById(int id) {
        return stTollsRepository.findById((long) id);
    }

    public StTollsEntity createTolls(StTollsEntity tolls) {
        return stTollsRepository.save(tolls);
    }

    public Optional<StTollsEntity> updateTolls(int id, StTollsEntity tollsDetails) {
        StTollsEntity tolls = stTollsRepository.findById((long) id).orElseThrow(() -> new RuntimeException("Tolls not found"));
        return Optional.of(stTollsRepository.save(tolls));
    }

    public void deleteTolls(int id) {
        stTollsRepository.deleteById((long) id);
    }

}
