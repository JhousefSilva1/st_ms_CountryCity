package com.smart.tolls.ucb.edu.bo.SmartTolls_CountryCityService.models.request;

import lombok.Data;

@Data
public class StTollsRequest {
    private Long idTolls;
    private String tollsName;
    private Long idPlaces;
}
