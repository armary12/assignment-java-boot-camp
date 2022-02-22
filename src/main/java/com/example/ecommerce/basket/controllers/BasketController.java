package com.example.ecommerce.basket.controllers;

import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BasketController {

    @Autowired
    ProductService productService;

    @PostMapping("/api/v1/basket")
    public ProductResponse getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

}
