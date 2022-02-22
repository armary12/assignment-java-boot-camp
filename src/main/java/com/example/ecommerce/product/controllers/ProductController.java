package com.example.ecommerce.product.controllers;

import com.example.ecommerce.landing.models.LandingResponse;
import com.example.ecommerce.landing.services.LandingService;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.product.repositories.entities.Product;
import com.example.ecommerce.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/api/v1/product/{id}")
    public ProductResponse getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/api/v1/product")
    public List<ProductResponse> getProducts(@RequestParam(value = "search", required = false) String search) {
        return productService.getProducts(search);
    }
}
