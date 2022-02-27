package com.example.ecommerce.order.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class OrderTransactionItem {
    @Id
    @GeneratedValue
    private int id;
    private int price;
    private int quantity;
    private int totalPrice;
    private int productId;
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "orderTransaction_id", nullable = false)
    private OrderTransaction orderTransaction;

}
