package com.example.ecommerce.order.controllers;

import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.order.models.OrderConfirmRequest;
import com.example.ecommerce.order.repositories.entities.OrderTransaction;
import com.example.ecommerce.product.models.ProductResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void confirmOrder() {
        // Arrange
        OrderConfirmRequest orderConfirmRequest = new OrderConfirmRequest();

        // Act
        ResponseModel<OrderTransaction> result = testRestTemplate.postForObject("/api/v1/order/confirm", orderConfirmRequest, ResponseModel.class);
        ObjectMapper mapper = new ObjectMapper();
        OrderTransaction orderTransaction = mapper.convertValue(result.getData(), new TypeReference<OrderTransaction>() {
        });

        // Assert
        assertEquals("success", result.getMessage());
    }
}