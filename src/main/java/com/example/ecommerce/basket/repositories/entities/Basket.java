package com.example.ecommerce.basket.repositories.entities;

import com.example.ecommerce.basket.models.BasketItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Basket {
    @Id
    @GeneratedValue
    private int id;
    @Lob
    private BasketItem[] basketItems;
    private int userId;
    private int totalPrice;
    private int totalQuantity;
    private Date createdDate;
    private Date updatedDate;
}
