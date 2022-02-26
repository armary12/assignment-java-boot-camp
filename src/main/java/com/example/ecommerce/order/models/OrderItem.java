package com.example.ecommerce.order.models;

import lombok.Data;

@Data
public class OrderItem {
	private int quantity;
	private int productId;
	private int totalPrice;
	private int price;
}