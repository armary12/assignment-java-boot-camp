package com.example.ecommerce.basket.controllers;

import com.example.ecommerce.basket.models.CreateBasketRequest;
import com.example.ecommerce.basket.models.GetBasketResponse;
import com.example.ecommerce.basket.repositories.entities.Basket;
import com.example.ecommerce.basket.services.BasketService;
import com.example.ecommerce.common.model.ResponseModel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BasketControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private BasketService basketService;

    @Test
    @DisplayName("Should be success and save basket")
    void createBasketSuccess() {
        // Arrange
        Basket basketMock = new Basket();
        basketMock.setUserId(123);
        CreateBasketRequest createBasketRequest = new CreateBasketRequest();
        createBasketRequest.setUserId(123);
        when(basketService.createBasket(any())).thenReturn(basketMock);

        // Act
        ResponseModel<Basket> result = testRestTemplate.postForObject("/api/v1/basket", createBasketRequest, ResponseModel.class);
        ObjectMapper mapper = new ObjectMapper();
        Basket basket = mapper.convertValue(result.getData(), new TypeReference<Basket>() {
        });

        // Assert
        assertEquals("success", result.getMessage());
        assertEquals(123, basket.getUserId());
    }

    @Test
    @DisplayName("Should be success and return basket by userId")
    void getBasketSuccess() {
        // Arrange
        GetBasketResponse getBasketResponse = new GetBasketResponse();
        getBasketResponse.setUserId(123);
        CreateBasketRequest createBasketRequest = new CreateBasketRequest();
        createBasketRequest.setUserId(123);
        when(basketService.getBasket(123)).thenReturn(getBasketResponse);

        // Act
        ResponseModel<Basket> result = testRestTemplate.getForObject("/api/v1/basket/123", ResponseModel.class);
        ObjectMapper mapper = new ObjectMapper();
        GetBasketResponse getBasketResponse1 = mapper.convertValue(result.getData(), new TypeReference<GetBasketResponse>() {
        });

        // Assert
        assertEquals("success", result.getMessage());
        assertEquals(123, getBasketResponse1.getUserId());
    }
}