package com.example.ecommerce.basket.controllers;

import com.example.ecommerce.basket.models.CreateBasketRequest;
import com.example.ecommerce.basket.repositories.entities.Basket;
import com.example.ecommerce.basket.services.BasketService;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketController {

    @Autowired
    BasketService basketService;

    @PostMapping("/api/v1/basket")
    public Basket createBasket(@RequestBody CreateBasketRequest createBasketRequest) {
        return basketService.createBasket(createBasketRequest);
    }
}
