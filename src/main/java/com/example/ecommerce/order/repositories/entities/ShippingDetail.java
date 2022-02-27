package com.example.ecommerce.order.repositories.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ShippingDetail{
	@Id
	@GeneratedValue
	private int id;
	private String shippingCost;
	private String shippingService;
}