package com.example.ecommerce.order.exceptions;

public class PaymentFailException extends RuntimeException{
    public PaymentFailException(String message) {
        super(message);
    }

}
