package com.example.ecommerce.order.models;

import lombok.Data;

@Data
public class PaymentDetail{
	private String cardHolderName;
	private String expiredDate;
	private String ccv;
	private String cardType;
	private String cardNumber;
}