package com.example.ecommerce.user.controllers;

import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.product.exceptions.ProductNotFoundException;
import com.example.ecommerce.user.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseModel userNotFound(UserNotFoundException e) {
        ResponseModel responseModel = new ResponseModel(null);
        responseModel.setMessage(e.getMessage());
        return responseModel;
    }
}
