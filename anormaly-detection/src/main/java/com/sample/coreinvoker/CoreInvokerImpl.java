package com.sample.coreinvoker;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.commons.ApiHeaderInvoker;
import com.sample.commons.ApiResponse;
import com.sample.commons.ResponseHandler;
import com.sample.exception.BusinessException;
import com.sample.exception.ConnectionException;
import com.sample.model.SmsAnomalyDetectorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;


@Service
@Slf4j
public class CoreInvokerImpl implements CoreInvoker {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiHeaderInvoker apiHeaderInvoker;


    @Override
    public <T, R> R invoke(T t, String resourceUrl, HttpMethod httpMethod, ParameterizedTypeReference parameterizedTypeReference) {


        try {

            RequestEntity<T> requestEntity = null;
            if(t == null) {
                requestEntity = new RequestEntity<>(apiHeaderInvoker.headerWithToken(),
                        httpMethod, new URI(resourceUrl));
            }else{
                requestEntity = new RequestEntity<>(t, apiHeaderInvoker.headerWithToken(),
                        httpMethod, new URI(resourceUrl));
            }
            restTemplate.setErrorHandler(new ResponseHandler());

            final ResponseEntity<String> responseEntity = restTemplate.exchange(resourceUrl, HttpMethod.POST, requestEntity, String.class);

            System.out.println("Sending Request " + responseEntity);

            if(responseEntity.getStatusCode() == HttpStatus.OK){
                ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                SmsAnomalyDetectorResponse smsAnomalyDetectorResponse = objectMapper.readValue(responseEntity.getBody(), SmsAnomalyDetectorResponse.class);
                ApiResponse res = new ApiResponse<SmsAnomalyDetectorResponse>();
                res.setStatus(200);
                res.setBody(smsAnomalyDetectorResponse);
                res.setMessage("Successfully");
                return (R)res;

            }
          throw new BusinessException("Error filtering data");



        } catch (URISyntaxException e) {
            throw new ConnectionException(e);
        } catch (JsonMappingException e) {
            throw new BusinessException(e.getMessage());
        } catch (JsonProcessingException e) {
            throw new BusinessException(e.getMessage());
        }

    }

}
