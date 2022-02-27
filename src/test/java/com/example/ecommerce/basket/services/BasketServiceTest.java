package com.example.ecommerce.basket.services;

import com.example.ecommerce.basket.exceptions.BasketNotFoundException;
import com.example.ecommerce.basket.models.BasketItem;
import com.example.ecommerce.basket.models.CreateBasketRequest;
import com.example.ecommerce.basket.models.GetBasketResponse;
import com.example.ecommerce.basket.repositories.BasketRepository;
import com.example.ecommerce.basket.repositories.entities.Basket;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.product.repositories.ProductRepository;
import com.example.ecommerce.product.services.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    private BasketRepository basketRepository;

    @Test
    @DisplayName("Should be success and save basket")
    void createBasketSuccess() {
        // Arrange
        CreateBasketRequest createBasketRequest = new CreateBasketRequest();
        createBasketRequest.setUserId(123);
        createBasketRequest.setBasketItems(new BasketItem[]{});
        Basket basketMock = new Basket();
        basketMock.setUserId(123);
        when(basketRepository.save(any())).thenReturn(basketMock);

        // Act
        BasketService basketService = new BasketService();
        basketService.setBasketRepository(basketRepository);
        Basket basket = basketService.createBasket(createBasketRequest);

        // Assert
        assertEquals(123, basket.getUserId());
    }

    @Test
    @DisplayName("Should be success and return basket with input userId")
    void getBasketSuccess() {
        // Arrange
        Basket basketMock = new Basket();
        basketMock.setUserId(123);
        when(basketRepository.findByUserId(123)).thenReturn(Optional.of(basketMock));

        // Act
        BasketService basketService = new BasketService();
        basketService.setBasketRepository(basketRepository);
        GetBasketResponse basket = basketService.getBasket(123);

        // Assert
        assertEquals(123, basket.getUserId());
    }

    @Test
    @DisplayName("Should be fail when basket not found")
    void getBasketFail() {
        // Arrange

        // Act
        BasketService basketService = new BasketService();
        basketService.setBasketRepository(basketRepository);

        // Assert
        assertThrows(BasketNotFoundException.class, () -> basketService.getBasket(123));
    }
}