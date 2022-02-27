package com.example.ecommerce.basket.controllers;

import com.example.ecommerce.basket.exceptions.BasketNotFoundException;
import com.example.ecommerce.common.model.ResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BasketControllerAdvice {

    @ExceptionHandler(BasketNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseModel basketNotFound(BasketNotFoundException e) {
        ResponseModel responseModel = new ResponseModel();
        responseModel.setMessage(e.getMessage());
        return responseModel;
    }
}
