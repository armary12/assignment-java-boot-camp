package com.example.ecommerce.order.controllers;

import com.example.ecommerce.common.model.ErrorResponse;
import com.example.ecommerce.order.exceptions.PaymentFailException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderControllerAdvice
{
    @ExceptionHandler(PaymentFailException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse paymentFail(PaymentFailException e) {
        return new ErrorResponse(e.getMessage());
    }
}
