package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCountryEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request.StCityRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCityService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCountryService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city")
public class StCityController extends ApiController{
    @Autowired
    private StCityService stCityService;

    @Autowired
    private StCountryService stCountryService;

    @GetMapping("/all")
    public ApiResponse<List<StCityEntity>> getAllCities(){
        ApiResponse<List<StCityEntity>> response = new ApiResponse<>();
        try {
            if (!stCityService.isServiceAvailable()) {
                response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
                response.setMessage("The city service is currently unavailable");
                return logApiResponse(response);
            }
            List<StCityEntity> cities = stCityService.getAllCities();
            validateCity(response, cities);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    private void validateCity(ApiResponse<List<StCityEntity>> response, List<StCityEntity> cities) {
        if(cities == null || cities.isEmpty()){
            response.setStatus(HttpStatus.NO_CONTENT.value());
            response.setMessage("No cities found");
        } else {
            response.setData(cities);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        }
    }

    @GetMapping
    public ApiResponse<List<StCityEntity>> getAllCitiesByStatus(){
        ApiResponse<List<StCityEntity>> response = new ApiResponse<>();
        try {
            if (!stCityService.isServiceAvailable()) {
                response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
                response.setMessage("The city service is currently unavailable");
                return logApiResponse(response);
            }
            List<StCityEntity> cities = stCityService.getAllCitiesByStatus();
            validateCity(response, cities);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StCityEntity> getCityById(@PathVariable Long id){
        ApiResponse<StCityEntity> response = new ApiResponse<>();
        try {
            if(id == null || id <= 0){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Invalid id");
                return logApiResponse(response);
            }
            Optional<StCityEntity> city = stCityService.getCityById(id);
            if(city.isPresent()){
                response.setData(city.get());
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("City with ID: " + id + " not found");
            }
        } catch (NullPointerException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("City with ID: " + id + " not found");
        } catch (DataAccessException e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("Database error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Invalid argument: " + e.getMessage());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    @PostMapping
    public ApiResponse<Optional<StCityEntity>> createCity(@RequestBody StCityRequest stCityEntity){
        ApiResponse<Optional<StCityEntity>> response = new ApiResponse<>();
        try {
            if(stCityEntity.getCityName() == null || stCityEntity.getCityName().isEmpty()){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("City name is required");
                return logApiResponse(response);
            }
            if(stCityEntity.getIdCountry() == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Country name is required");
                return logApiResponse(response);
            }
            Optional<StCountryEntity> country = stCountryService.getCountryById(stCityEntity.getIdCountry());
            if(country.isPresent()){
                StCityEntity cityEntity = new StCityEntity();
                cityEntity.setCityName(stCityEntity.getCityName());
                cityEntity.setCountry(country.get());
                Optional<StCityEntity> city = stCityService.createCity(cityEntity);
                response.setData(city);
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            }else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("Country with ID: " + stCityEntity.getIdCountry() + " not found");
            }
        } catch (ConstraintViolationException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Validation error: " + e.getMessage());
        } catch (DataIntegrityViolationException e) {
            response.setStatus(HttpStatus.CONFLICT.value());
            response.setMessage("Data integrity error: " + e.getMessage());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    @PutMapping("/{id}")
    public ApiResponse<Optional<StCityEntity>> updateCity(@PathVariable Long id, @RequestBody StCityRequest stCityEntity){
        ApiResponse<Optional<StCityEntity>> response = new ApiResponse<>();
        try {
            if(id == null || id <= 0){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Invalid id");
                return logApiResponse(response);
            }
            if(stCityEntity.getCityName() == null || stCityEntity.getCityName().isEmpty()){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("City name is required");
                return logApiResponse(response);
            }
            if(stCityEntity.getIdCountry() == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Country name is required");
                return logApiResponse(response);
            }
            Optional<StCountryEntity> country = stCountryService.getCountryById(stCityEntity.getIdCountry());
            if(country.isPresent()){
                StCityEntity cityEntity = new StCityEntity();
                cityEntity.setCityName(stCityEntity.getCityName());
                cityEntity.setCountry(country.get());
                cityEntity.setIdCity(cityEntity.getIdCity());
                Optional<StCityEntity> city = stCityService.updateCity(id, cityEntity);
                response.setData(city);
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("Country with ID: " + stCityEntity.getIdCountry() + " not found");
            }
        } catch (ConstraintViolationException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Validation error: " + e.getMessage());
        } catch (DataIntegrityViolationException e) {
            response.setStatus(HttpStatus.CONFLICT.value());
            response.setMessage("Data integrity error: " + e.getMessage());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
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
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }
}
