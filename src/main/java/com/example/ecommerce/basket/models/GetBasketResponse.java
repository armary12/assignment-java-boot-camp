package com.example.ecommerce.basket.models;

import lombok.Data;

@Data
public class GetBasketResponse {
    private int id;
    private int userId;
    private BasketItem[] basketItems;
    private int totalPrice;
    private int totalQuantity;
}
