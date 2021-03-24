package com.sample.api;

import com.sample.commons.ApiResponse;
import com.sample.commons.Response;
import com.sample.service.SmsAnomalyDetectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SmsAnomalyDetectorController {

    @Autowired
    private SmsAnomalyDetectorService smsAnomalyDetectorService;

    @GetMapping("/azure")
    public Response postingToAzure(){

         ApiResponse apiResponse = smsAnomalyDetectorService.detectAnomaly();
        return new Response(200, "Success" , apiResponse);
    }

//    @PostMapping("/detect")
//    public ApiResponse<SOcp-Apim-Subscription-KeymsAnomalyDetectorResponse>  sendingDataPost(@RequestBody SmsAnomalyDetectorRequest smsAnomalyDetectorRequest) throws IOException {
//
//      return null;
//
//    }

}
