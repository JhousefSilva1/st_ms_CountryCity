package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StRoadTypeEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StRoadTypeService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roadType")
public class StRoadTypeController extends ApiController {
    @Autowired
    private StRoadTypeService stRoadTypeService;

    @GetMapping("/all")
    public ApiResponse<List<StRoadTypeEntity>> getAllRoadTypes() {
        ApiResponse<List<StRoadTypeEntity>> response = new ApiResponse<>();
        List<StRoadTypeEntity> roadTypes = stRoadTypeService.getAllRoadTypes();
        response.setData(roadTypes);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping
    public ApiResponse<List<StRoadTypeEntity>> getAllRoadTypesByStatus() {
        ApiResponse<List<StRoadTypeEntity>> response = new ApiResponse<>();
        List<StRoadTypeEntity> roadTypes = stRoadTypeService.getAllRoadTypeByStatus();
        response.setData(roadTypes);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StRoadTypeEntity> getRoadTypeById(@PathVariable("id") Long id) {
        ApiResponse<StRoadTypeEntity> response = new ApiResponse<>();
        try {
            Optional<StRoadTypeEntity> roadType = stRoadTypeService.getRoadTypeById(id);
            if(roadType.isPresent()) {
                response.setData(roadType.get());
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
    public ApiResponse<Optional<StRoadTypeEntity>> createRoadType(@RequestBody StRoadTypeEntity roadType) {
        ApiResponse<Optional<StRoadTypeEntity>> response = new ApiResponse<>();
        try {
            Optional<StRoadTypeEntity> roadTypeEntity = stRoadTypeService.createRoadType(roadType);
            response.setData(roadTypeEntity);
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
    public ApiResponse<Optional<StRoadTypeEntity>> updateRoadType(@PathVariable("id") Long id, @RequestBody StRoadTypeEntity roadType) {
        ApiResponse<Optional<StRoadTypeEntity>> response = new ApiResponse<>();
        try {
            Optional<StRoadTypeEntity> roadTypeEntity = stRoadTypeService.updateRoadType(id, roadType);
            response.setData(roadTypeEntity);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Optional<StRoadTypeEntity>> deleteRoadType(@PathVariable("id") Long id) {
        ApiResponse<Optional<StRoadTypeEntity>> response = new ApiResponse<>();
        try {
            Optional<StRoadTypeEntity> roadType = stRoadTypeService.deleteRoadType(id);
            response.setData(roadType);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }
}
