package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCityService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city")
public class StCityController extends ApiController{
    @Autowired
    private StCityService stCityService;

    @GetMapping
    public ApiResponse<List<StCityEntity>> getAllCities(){
        ApiResponse<List<StCityEntity>> response = new ApiResponse<>();
        List<StCityEntity> cities = stCityService.getAllCities();
        response.setData(cities);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StCityEntity> getCityById(@PathVariable Long id){
        ApiResponse<StCityEntity> response = new ApiResponse<>();
        try {
            Optional<StCityEntity> city = stCityService.getCityById(id);
            if(city.isPresent()){
                response.setData(city.get());
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (NullPointerException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @PostMapping
    public ApiResponse<Optional<StCityEntity>> createCity(@RequestBody StCityEntity stCityEntity){
        ApiResponse<Optional<StCityEntity>> response = new ApiResponse<>();
        try {
            Optional<StCityEntity> city = stCityService.createCity(stCityEntity);
            response.setData(city);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (ConstraintViolationException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @PutMapping("/{id}")
    public ApiResponse<Optional<StCityEntity>> updateCity(@PathVariable Long id, @RequestBody StCityEntity stCityEntity){
        ApiResponse<Optional<StCityEntity>> response = new ApiResponse<>();
        try {
            Optional<StCityEntity> city = stCityService.updateCity(id, stCityEntity);
            response.setData(city);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Optional<StCityEntity>> deleteCity(@PathVariable Long id){
        ApiResponse<Optional<StCityEntity>> response = new ApiResponse<>();
        try {
            Optional<StCityEntity> city = stCityService.deleteCity(id);
            response.setData(city);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }
}
