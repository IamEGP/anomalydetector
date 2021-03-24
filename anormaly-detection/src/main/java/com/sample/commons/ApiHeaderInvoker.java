package com.sample.commons;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Service
@Slf4j
public class ApiHeaderInvoker {

    @Autowired
    private HttpSession httpSession;

    @Value("${api.anomaly.key}")
    private String key;


    public HttpHeaders headerWithToken() {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.TEXT_PLAIN);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
       httpHeaders.add("Ocp-Apim-Subscription-Key", key);
        return httpHeaders;
    }

}
