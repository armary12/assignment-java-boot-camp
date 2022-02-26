package com.example.ecommerce.basket.models;

import lombok.Data;

@Data
public class BasketItem {
    private int productId;
    private String productName;
    private String productImg;
    private String productSize;
    private String ShopName;
    private int productPrice;
    private int discountPercent;
    private int productQuantity;
}
