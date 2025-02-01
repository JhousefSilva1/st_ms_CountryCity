package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request.StPlacesRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StCityService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StPlacesService;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/places")
public class StPlacesController extends ApiController {
    @Autowired
    private StPlacesService stPlacesService;

    @Autowired
    private StCityService stCityService;

    //getAllPlaces
    @GetMapping("/all")
    public ApiResponse<List<StPlacesEntity>> getAllPlaces() {
        ApiResponse<List<StPlacesEntity>> response = new ApiResponse<>();
        try {
            if (!stPlacesService.isServiceAvailable()) {
                response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
                response.setMessage("The places service is currently unavailable");
                return logApiResponse(response);
            }
            List<StPlacesEntity> placesEntities = stPlacesService.getAllPlaces();
            response.setData(placesEntities);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    //getAllPlacesByStatus
    @GetMapping
    public ApiResponse<List<StPlacesEntity>> getAllPlacesByStatus() {
        ApiResponse<List<StPlacesEntity>> response = new ApiResponse<>();
        try {
            List<StPlacesEntity> placesEntities = stPlacesService.getAllPlacesByStatus();
            response.setData(placesEntities);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    //GetAllPlacesById
    @GetMapping("/{id}")
    public ApiResponse<StPlacesEntity> getPlacesById(@PathVariable Long id) {
        ApiResponse<StPlacesEntity> response = new ApiResponse<>();
        try {
            if(id == null || id <= 0){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Invalid id");
                return logApiResponse(response);
            }
            Optional<StPlacesEntity> place = stPlacesService.getPlaceById(id);
            if(place.isPresent()) {
                response.setData(place.get());
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage(HttpStatus.NOT_FOUND.getReasonPhrase());
            }
        } catch (NullPointerException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMessage("Place with ID: " + id + " not found");
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
    public ApiResponse<Optional<StPlacesEntity>> createPlaces(@RequestBody StPlacesRequest stPlacesRequest) {
        ApiResponse<Optional<StPlacesEntity>> response = new ApiResponse<>();
        try {
            if(stPlacesRequest.getPlaceName() == null || stPlacesRequest.getPlaceName().isEmpty()){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Place name is required");
                return logApiResponse(response);
            }
            if(stPlacesRequest.getIdCity() == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("City is required");
                return logApiResponse(response);
            }
            Optional<StCityEntity> city = stCityService.getCityById(stPlacesRequest.getIdCity());
            if(city.isPresent()){
                StPlacesEntity placesEntity = new StPlacesEntity();
                placesEntity.setPlaceName(stPlacesRequest.getPlaceName());
                placesEntity.setCity(city.get());
                Optional<StPlacesEntity> savedPlaces = stPlacesService.createPlaces(placesEntity);
                response.setData(savedPlaces);
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
              response.setStatus(HttpStatus.NOT_FOUND.value());
              response.setMessage("Place with ID: " + stPlacesRequest.getIdCity() + " not found");
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
    public ApiResponse<Optional<StPlacesEntity>> updatePlaces(@PathVariable Long id, @RequestBody StPlacesRequest stPlacesRequest) {
        ApiResponse<Optional<StPlacesEntity>> response = new ApiResponse<>();
        try {
            if(id == null || id <= 0){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Invalid id");
                return logApiResponse(response);
            }
            if(stPlacesRequest.getPlaceName() == null || stPlacesRequest.getPlaceName().isEmpty()){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Place name is required");
                return logApiResponse(response);
            }
            if(stPlacesRequest.getIdCity() == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("City is required");
                return logApiResponse(response);
            }
            Optional<StCityEntity> city = stCityService.getCityById(stPlacesRequest.getIdCity());
            if(city.isPresent()){
                StPlacesEntity placesEntity = new StPlacesEntity();
                placesEntity.setPlaceName(stPlacesRequest.getPlaceName());
                placesEntity.setCity(city.get());
                Optional<StPlacesEntity> updatedPlaces = stPlacesService.updatePlaces(id, placesEntity);
                response.setData(updatedPlaces);
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            }
        } catch (ConstraintViolationException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Optional<StPlacesEntity>> deletePlaces(@PathVariable Long id) {
        ApiResponse<Optional<StPlacesEntity>> response = new ApiResponse<>();
        try {
            Optional<StPlacesEntity> deletedPlaces = stPlacesService.deletePlaces(id);
            response.setData(deletedPlaces);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }
}
