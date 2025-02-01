package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request;

import com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.entity.StCityEntity;
import lombok.Data;

@Data
public class StPlacesRequest {
    private Long idPlaces;
    private String placeName;
    private Integer status;
    private Long idCity;
}
