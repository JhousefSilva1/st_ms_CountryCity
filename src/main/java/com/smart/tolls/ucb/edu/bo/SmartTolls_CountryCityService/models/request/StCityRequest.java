package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request;

import lombok.Data;

@Data
public class StCityRequest {
    private Long idCity;
    private String cityName;
    private Integer status;
    private Long idCountry;
}
