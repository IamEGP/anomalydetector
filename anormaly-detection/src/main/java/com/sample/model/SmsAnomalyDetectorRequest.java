package com.sample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsAnomalyDetectorRequest {

    @JsonProperty(value = "series")
    private List<Series> seriesList;

    private float maxAnomalyRatio;

    private int sensitivity;

    private String granulity;



}
