package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StPlacesService;
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
@RequestMapping("/api/places")
public class StPlacesController extends ApiController {
    @Autowired
    private StPlacesService stPlacesService;

    //getAllPlaces
    @GetMapping
    public ApiResponse<List<StPlacesEntity>> getAllPlaces() {
        ApiResponse<List<StPlacesEntity>> response = new ApiResponse<>();
        List<StPlacesEntity> placesEntities = stPlacesService.getAllPlaces();
        response.setData(placesEntities);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    //GetAllPlacesById
    @GetMapping("/{id}")
    public StPlacesEntity getPersonById(@PathVariable Long id) {
        return stPlacesService.getPlaceById(id);
    }

    @PostMapping
    public ApiResponse<Optional<StPlacesEntity>> createPlaces(@RequestBody StPlacesEntity stPlacesEntity) {
        ApiResponse<Optional<StPlacesEntity>> response = new ApiResponse<>();
        try {
            Optional<StPlacesEntity> savedPlaces = stPlacesService.createPlaces(stPlacesEntity);
            response.setData(savedPlaces);
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
    public ApiResponse<Optional<StPlacesEntity>> updatePlaces(@PathVariable Long id, @RequestBody StPlacesEntity stPlacesEntity) {
        ApiResponse<Optional<StPlacesEntity>> response = new ApiResponse<>();
        try {
            Optional<StPlacesEntity> updatedPlaces = stPlacesService.updatePlaces(id, stPlacesEntity);
            response.setData(updatedPlaces);
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
