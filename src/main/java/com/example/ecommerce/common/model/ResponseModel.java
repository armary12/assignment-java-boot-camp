package com.example.ecommerce.common.model;

import lombok.Data;

@Data
public class ResponseModel<T> {
    private String message = "success";
    private T data;


    public ResponseModel() {}

    public ResponseModel(T data) {
        this.data = data;
    }
}

