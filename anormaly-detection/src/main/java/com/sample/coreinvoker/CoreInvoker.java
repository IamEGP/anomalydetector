package com.sample.coreinvoker;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public interface CoreInvoker {

    <T, R> R invoke(T t, String resourceUrl, HttpMethod httpMethod, ParameterizedTypeReference parameterizedTypeReference);

}