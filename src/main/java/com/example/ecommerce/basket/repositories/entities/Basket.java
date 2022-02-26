package com.example.ecommerce.basket.repositories.entities;

import com.example.ecommerce.basket.models.BasketItem;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data
public class Basket {
    @Id
    @GeneratedValue
    private int id;
    @Transient
    private BasketItem[] basketItem;
    private int userId;
    private int totalPrice;
    private int totalQuantity;
    private Date createdDate;
    private Date updatedDate;
}
