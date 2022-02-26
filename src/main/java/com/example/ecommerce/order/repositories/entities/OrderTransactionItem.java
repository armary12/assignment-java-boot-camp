package com.example.ecommerce.order.repositories.entities;

import com.example.ecommerce.order.models.PaymentDetail;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class OrderTransactionItem {
    @Id
    private int id;
    private int orderTransactionId;
    private int price;
    private int quantity;
    private int totalPrice;
    private Date createdDate;
}
