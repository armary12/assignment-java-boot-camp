package com.example.ecommerce.basket.controllers;

import com.example.ecommerce.basket.models.CreateBasketRequest;
import com.example.ecommerce.basket.models.GetBasketResponse;
import com.example.ecommerce.basket.repositories.entities.Basket;
import com.example.ecommerce.basket.services.BasketService;
import com.example.ecommerce.common.model.ResponseModel;
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
    public ResponseModel<Basket> createBasket(@RequestBody CreateBasketRequest createBasketRequest) {
        return new ResponseModel(basketService.createBasket(createBasketRequest));
    }

    @GetMapping("/api/v1/basket/{userId}")
    public ResponseModel<GetBasketResponse> getBasket(@PathVariable int userId) {
        return new ResponseModel(basketService.getBasket(userId));
    }

}
