package com.example.ecommerce.order.repositories.entities;

import com.example.ecommerce.order.models.PaymentDetail;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class OrderTransaction {
    @Id
    private int id;
    private int netPrice;
    private int deliveryPrice;
    private int totalItemPrice;
    private int totalItemQuantity;
    private int userId;
    private PaymentDetail paymentDetail;
    private String deliveryAddress;
    private String deliveryLat;
    private String deliveryLng;
    private String shopLat;
    private String shopLng;
    private String promotionDetail;
    private Date CreatedDate;
}
