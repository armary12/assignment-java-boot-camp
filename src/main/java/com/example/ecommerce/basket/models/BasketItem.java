package com.example.ecommerce.basket.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class BasketItem implements Serializable {
    private int productId;
    private String productName;
    private String productImg;
    private String productSize;
    private String shopName;
    private int productPrice;
    private int netPrice;
    private int discountPercent;
    private int productQuantity;
}
