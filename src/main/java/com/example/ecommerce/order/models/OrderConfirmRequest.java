package com.example.ecommerce.order.models;

import com.example.ecommerce.order.repositories.entities.PaymentDetail;
import com.example.ecommerce.order.repositories.entities.PromotionDetail;
import com.example.ecommerce.order.repositories.entities.ShippingDetail;
import lombok.Data;

@Data
public class OrderConfirmRequest{
	private PromotionDetail promotionDetail;
	private int netPrice;
	private int deliveryPrice;
	private int userId;
	private ShippingDetail shippingDetail;
	private PaymentDetail paymentDetail;
	private String deliveryAddress;
	private int totalItemPrice;
	private int totalItemQuantity;
	private OrderItem[] orderItems;
}