package com.example.ecommerce.order.models;

import lombok.Data;

import java.util.Date;

@Data
public class PaymentDetail {
    private String cardType;
    private String cardNumber;
    private String cardHolderName;
    private Date expiredDate;
    private String ccv;
}
