package com.sample.commons;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private int status;
    private String message;
    private T body;



}