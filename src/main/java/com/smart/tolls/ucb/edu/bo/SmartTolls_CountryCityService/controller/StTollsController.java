package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.controller;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StTollsEntity;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.response.ApiResponse;
import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.service.StTollsService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/toll")
public class StTollsController extends ApiController {
    @Autowired
    private StTollsService stTollsService;

    @GetMapping("/all")
    public ApiResponse<List<StTollsEntity>> getAllTolls(){
        ApiResponse<List<StTollsEntity>> response = new ApiResponse<>();
        List<StTollsEntity> tolls = stTollsService.getAllTolls();
        response.setData(tolls);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping
    public ApiResponse<List<StTollsEntity>> getAllTollsByStatus(){
        ApiResponse<List<StTollsEntity>> response = new ApiResponse<>();
        List<StTollsEntity> tolls = stTollsService.getAllTollsByStatus();
        response.setData(tolls);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return logApiResponse(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<StTollsEntity> getTollsById(@PathVariable("id") Long id){
        ApiResponse<StTollsEntity> response = new ApiResponse<>();
        try {
            Optional<StTollsEntity> toll = stTollsService.getTollsById(id);
            if(toll.isPresent()){
                response.setData(toll.get());
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
    public ApiResponse<Optional<StTollsEntity>> createToll(@RequestBody StTollsEntity stTollsEntity){
        ApiResponse<Optional<StTollsEntity>> response = new ApiResponse<>();
        try {
            Optional<StTollsEntity> toll = stTollsService.createTolls(stTollsEntity);
            response.setData(toll);
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
    public ApiResponse<Optional<StTollsEntity>> updateToll(@PathVariable("id") Long id, @RequestBody StTollsEntity stTollsEntity){
        ApiResponse<Optional<StTollsEntity>> response = new ApiResponse<>();
        try {
            Optional<StTollsEntity> toll = stTollsService.updateTolls(id, stTollsEntity);
            response.setData(toll);
            response.setStatus(HttpStatus.OK.value());
            response.setMessage(HttpStatus.OK.getReasonPhrase());
        } catch (Exception e) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
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
            response.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return logApiResponse(response);
    }


}
