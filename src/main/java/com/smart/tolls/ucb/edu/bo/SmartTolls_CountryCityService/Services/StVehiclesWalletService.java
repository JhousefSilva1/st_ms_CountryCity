package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Services;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.Repository.StVehiclesWalletRepository;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StVehiclesWalletEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StVehiclesWalletService {

    @Autowired
    private StVehiclesWalletRepository stVehiclesWalletRepository;

    public List<StVehiclesWalletEntity> getAllVehiclesWallet() {
        return stVehiclesWalletRepository.findAll();
    }

    public Optional<StVehiclesWalletEntity>getVehiclesWalletById(int id){
        return stVehiclesWalletRepository.findById((long) id);
    }

    public StVehiclesWalletEntity createVehiclesWallet(StVehiclesWalletEntity vehiclesWallet){
        return stVehiclesWalletRepository.save(vehiclesWallet);
    }

    public StVehiclesWalletEntity updateVehiclesWallet(int id, StVehiclesWalletEntity vehiclesWalletDetails) {
        StVehiclesWalletEntity vehiclesWallet = stVehiclesWalletRepository.findById((long) id).orElseThrow(() -> new RuntimeException("VehiclesWallet not found"));
//        vehiclesWallet.setVehicleWallet(vehiclesWalletDetails.getVehicleWallet());
//        vehiclesWallet.setId(vehiclesWalletDetails.getId());
        return stVehiclesWalletRepository.save(vehiclesWallet);
    }

    public void deleteVehiclesWallet(int id) {
        stVehiclesWalletRepository.deleteById((long) id);
    }
}
