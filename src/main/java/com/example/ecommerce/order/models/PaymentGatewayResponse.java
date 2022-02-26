package com.example.ecommerce.order.models;

import lombok.Data;

@Data
public class PaymentGatewayResponse{
	private String statusMessage;
	private int transactionId;
	private String approvalCode;
	private int responseCode;
	private boolean success;
	private String avsResponse;
	private String externalTransactionId;
	private String approvalMessage;
	private String cscResponse;
}