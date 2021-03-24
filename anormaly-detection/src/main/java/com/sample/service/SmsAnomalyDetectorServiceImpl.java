package com.sample.service;

import com.sample.commons.ApiResponse;
import com.sample.coreinvoker.CoreInvoker;
import com.sample.model.Series;
import com.sample.model.SmsAnomalyDetectorRequest;
import com.sample.model.SmsAnomalyDetectorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class SmsAnomalyDetectorServiceImpl implements SmsAnomalyDetectorService {

    @Value("${southafricanorth.api.cognitive.microsoft.com.url}")
    private String url;

    @Autowired
    private CoreInvoker coreInvoker;

    @Override
    public ApiResponse<SmsAnomalyDetectorResponse> detectAnomaly() {

        return coreInvoker.invoke(createRequest(), url, HttpMethod.POST,new ParameterizedTypeReference<ApiResponse<SmsAnomalyDetectorResponse>>(){});
    }

    public SmsAnomalyDetectorRequest createRequest(){
        File file ;

        try {
            file = new File("/home/anesusiwella/Desktop/source");

        Scanner scan = new Scanner(file);
        List<String> dates = new ArrayList<String>();
        List<String> regions = new ArrayList<>();
        List<Series> series = new ArrayList<>();

        while (scan.hasNextLine())
        {
            String[] lineValues = scan.nextLine().split(" ");

            dates.add(lineValues[0].substring(1));
            regions.add(lineValues[5].substring((lineValues[5].indexOf('|') + 1), lineValues[5].lastIndexOf("|")));
        }

        for (int i = 0; i < dates.size(); i++) {

            series.add(new Series(dates.get(i),regions.get(i)));
            System.out.println( series.get(i));

        }


        return  new SmsAnomalyDetectorRequest(
                series , 0.25F, 10,"daily"
        );

        }
        catch (Exception e){
            System.out.println("Error Loading File, "+ e);
        }
        return null;

    }
}
