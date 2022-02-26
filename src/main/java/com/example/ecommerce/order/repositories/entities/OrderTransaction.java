package com.example.ecommerce.order.repositories.entities;

import com.example.ecommerce.order.models.PaymentDetail;
import com.example.ecommerce.order.models.PromotionDetail;
import com.example.ecommerce.order.models.ShippingDetail;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class OrderTransaction {
    @Id
    @GeneratedValue
    private int id;
    private int netPrice;
    private int deliveryPrice;
    private int totalItemPrice;
    private int totalItemQuantity;
    private int userId;
    private PaymentDetail paymentDetail;
    private String deliveryAddress;
    private PromotionDetail promotionDetail;
    private ShippingDetail shippingDetail;
    private String orderStatus;
    private Date CreatedDate;
}
