package com.sample.service;

import com.sample.commons.ApiResponse;
import com.sample.model.SmsAnomalyDetectorResponse;

public interface SmsAnomalyDetectorService  {

    ApiResponse<SmsAnomalyDetectorResponse> detectAnomaly();

}
