package com.example.ecommerce.order.models;

import lombok.Data;

@Data
public class PromotionDetail{
	private int discountAmount;
	private String discountType;
	private int promotionId;
}