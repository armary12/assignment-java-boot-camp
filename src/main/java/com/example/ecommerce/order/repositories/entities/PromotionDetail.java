package com.example.ecommerce.order.repositories.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class PromotionDetail{
	@Id
	@GeneratedValue
	private int id;
	private int discountAmount;
	private String discountType;
	private int promotionId;
}