package com.example.ecommerce.product.controllers;

import com.example.ecommerce.product.models.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Should return product with id = 1 when receive input productId = 1")
    void getProductById() {
        ProductResponse result = testRestTemplate.getForObject("/api/v1/product/1", ProductResponse.class);
        assertEquals(1, result.getId());
    }

    @Test
    @DisplayName("Should return product with id = 1 when receive input productId = 1")
    void getProducts() {
        ProductResponse result = testRestTemplate.getForObject("/api/v1/product/12", ProductResponse.class);
        System.out.println(result);
        assertEquals(1, result.getId());
    }
}