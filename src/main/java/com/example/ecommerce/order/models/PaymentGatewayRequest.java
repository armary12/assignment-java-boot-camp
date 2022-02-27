package com.example.ecommerce.order.models;

import lombok.Data;

@Data
public class PaymentGatewayRequest {
    private int userId;
    private int orderId;
    private int totalAmount;
    private String cardType;
    private String cardNumber;
    private String cardHolderName;
    private String expiredDate;
    private String ccv;
}
