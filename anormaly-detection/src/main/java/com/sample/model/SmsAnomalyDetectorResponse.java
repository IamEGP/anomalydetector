package com.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsAnomalyDetectorResponse {

    @JsonIgnoreProperties( value = "expectedValues")
    private List<Float> expectedValues;

    @JsonIgnoreProperties( value = "isAnomaly")
    private List<Boolean> isAnomaly;

    @JsonIgnoreProperties( value = "isNegativeAnomaly")
    private List<Boolean> isNegativeAnomaly;

    @JsonIgnoreProperties( value = "isPositiveAnomaly")
    private List<Boolean> isPositiveAnomaly;

    @JsonIgnoreProperties( value = "lowerMargins")
    private List<Float> lowerMargins;

    @JsonIgnoreProperties( value = "periods")
    private Float periods;

    @JsonIgnoreProperties( value = "upperMargins")
    private List<Float> upperMargins;

}
