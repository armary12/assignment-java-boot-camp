package com.example.ecommerce.product.controllers;

import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.product.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseModel productNotfound(ProductNotFoundException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setMessage(e.getMessage());
        return responseModel;
    }
}
