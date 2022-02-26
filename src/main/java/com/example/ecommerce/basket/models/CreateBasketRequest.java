package com.example.ecommerce.basket.models;

import lombok.Data;

@Data
public class CreateBasketRequest {
    private int userId;
    private BasketItem[] basketItems;
}
