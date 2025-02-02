package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StPlacesEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTollsEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request.StTollsRequest;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StPlacesService;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StTollsService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/toll")
public class StTollsController extends ApiController {
    @Autowired
    private StTollsService stTollsService;

    @Autowired
    private StPlacesService stPlacesService;

    @GetMapping("/all")
    public ApiResponse<List<StTollsEntity>> getAllTolls(){
        ApiResponse<List<StTollsEntity>> response = new ApiResponse<>();
        try {
            if (!stTollsService.isServiceAvailable()) {
                response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
                response.setMessage("The places service is currently unavailable");
                return logApiResponse(response);
            }
            List<StTollsEntity> tolls = stTollsService.getAllTolls();
            response.setData(tolls);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    @GetMapping
    public ApiResponse<List<StTollsEntity>> getAllTollsByStatus(){
        ApiResponse<List<StTollsEntity>> response = new ApiResponse<>();
        try {
            if (!stTollsService.isServiceAvailable()) {
                response.setStatus(HttpStatus.SERVICE_UNAVAILABLE.value());
                response.setMessage("The places service is currently unavailable");
                return logApiResponse(response);
            }
            List<StTollsEntity> tolls = stTollsService.getAllTollsByStatus();
            response.setData(tolls);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StTollsEntity> getTollsById(@PathVariable("id") Long id){
        ApiResponse<StTollsEntity> response = new ApiResponse<>();
        try {
            if(id == null || id <= 0){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Invalid id");
                return logApiResponse(response);
            }
            Optional<StTollsEntity> toll = stTollsService.getTollsById(id);
            if(toll.isPresent()){
                response.setData(toll.get());
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("Place with ID: " + id + " not found");
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
    public ApiResponse<Optional<StTollsEntity>> createToll(@RequestBody StTollsRequest stTollsRequest){
        ApiResponse<Optional<StTollsEntity>> response = new ApiResponse<>();
        try {
            if(stTollsRequest.getTollsName() == null || stTollsRequest.getTollsName().isEmpty()){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Tolls name is required");
                return logApiResponse(response);
            }
            if(stTollsRequest.getIdPlaces() == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Id places is required");
                return logApiResponse(response);
            }
            Optional<StPlacesEntity> place = stPlacesService.getPlaceById(stTollsRequest.getIdPlaces());
            if(place.isPresent()){
                StTollsEntity tollEntity = new StTollsEntity();
                tollEntity.setTollsName(stTollsRequest.getTollsName());
                tollEntity.setPlaces(place.get());
                Optional<StTollsEntity> toll = stTollsService.createTolls(tollEntity);
                response.setData(toll);
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("Place with ID: " + stTollsRequest.getIdPlaces() + " not found");
            }
        } catch (ConstraintViolationException e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("Validation error: " + e.getMessage());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }

    @PutMapping("/{id}")
    public ApiResponse<Optional<StTollsEntity>> updateToll(@PathVariable("id") Long id, @RequestBody StTollsRequest stTollsRequest){
        ApiResponse<Optional<StTollsEntity>> response = new ApiResponse<>();
        try {
            if(id == null || id <= 0){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Invalid id");
                return logApiResponse(response);
            }
            if(stTollsRequest.getTollsName() == null || stTollsRequest.getTollsName().isEmpty()){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Tolls name is required");
                return logApiResponse(response);
            }
            if (stTollsRequest.getIdPlaces() == null){
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                response.setMessage("Id places is required");
                return logApiResponse(response);
            }
            Optional<StPlacesEntity> places = stPlacesService.getPlaceById(stTollsRequest.getIdPlaces());
            if (places.isPresent()){
                StTollsEntity tollEntity = new StTollsEntity();
                tollEntity.setTollsName(stTollsRequest.getTollsName());
                tollEntity.setPlaces(places.get());
                Optional<StTollsEntity> toll = stTollsService.updateTolls(id, tollEntity);
                response.setData(toll);
                response.setStatus(HttpStatus.OK.value());
                response.setMessage(HttpStatus.OK.getReasonPhrase());
            } else {
                response.setStatus(HttpStatus.NOT_FOUND.value());
                response.setMessage("Place with ID: " + id + " not found");
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
    public ApiResponse<Optional<StTollsEntity>> deleteToll(@PathVariable("id") Long id){
        ApiResponse<Optional<StTollsEntity>> response = new ApiResponse<>();
        try {
            Optional<StTollsEntity> toll = stTollsService.deleteTolls(id);
            response.setData(toll);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage("An unexpected error occurred: " + e.getMessage());
        }
        return logApiResponse(response);
    }


}
