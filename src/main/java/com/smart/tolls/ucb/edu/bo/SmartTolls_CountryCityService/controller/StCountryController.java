package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCountryService;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/country")
public class StCountryController extends ApiController {

    @Autowired
    private StCountryService stCountryService;

    @GetMapping("/all")
    public ApiResponse<List<StCountryEntity>> getAllCountries(){
        ApiResponse<List<StCountryEntity>> response = new ApiResponse<>();
        List<StCountryEntity> countryEntities = stCountryService.getAllCountries();
        response.setData(countryEntities);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping
    public ApiResponse<List<StCountryEntity>> getAllCountriesByStatus(){
        ApiResponse<List<StCountryEntity>> response = new ApiResponse<>();
        List<StCountryEntity> countryEntities = stCountryService.getAllCountriesByStatus();
        response.setData(countryEntities);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StCountryEntity> getCountryById(@PathVariable Long id){
        ApiResponse<StCountryEntity> response = new ApiResponse<>();
        try {
            Optional<StCountryEntity> country = stCountryService.getCountryById(id);
            if(country.isPresent()){
                response.setData(country.get());
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (NullPointerException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @PostMapping
    public ApiResponse<Optional<StCountryEntity>> createCountry(@RequestBody StCountryEntity stCountryEntity){
        ApiResponse<Optional<StCountryEntity>> response = new ApiResponse<>();
        try {
            Optional<StCountryEntity> savedCountry = stCountryService.createCountry(stCountryEntity);
            response.setData(savedCountry);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (ConstraintViolationException e){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception e){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @PutMapping("/{id}")
    public ApiResponse<Optional<StCountryEntity>> updateCountry(@PathVariable Long id, @RequestBody StCountryEntity stCountryEntity){
        ApiResponse<Optional<StCountryEntity>> response = new ApiResponse<>();
        try {
            Optional<StCountryEntity> savedCountry = stCountryService.updateCountry(id, stCountryEntity);
            response.setData(savedCountry);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e){
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Optional<StCountryEntity>> deleteCountry(@PathVariable Long id){
        ApiResponse<Optional<StCountryEntity>> response = new ApiResponse<>();
        try {
            Optional<StCountryEntity> savedCountry = stCountryService.deleteCountry(id);
            response.setData(savedCountry);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(e.toString());
        }
        return logApiResponse(response);
    }

}
