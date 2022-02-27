package com.example.ecommerce.basket.repositories;

import com.example.ecommerce.basket.repositories.entities.Basket;
import com.example.ecommerce.product.repositories.ProductRepository;
import com.example.ecommerce.product.repositories.entities.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BasketRepositoryTest {

    @Autowired
    BasketRepository basketRepository;

    @Test
    @DisplayName("Should be success and return basket with match userId")
    void findByUserIdSuccess() {
        // Arrange
        Basket basket = new Basket();
        basket.setUserId(123);
        basketRepository.save(basket);

        // Act
        Optional<Basket> result = basketRepository.findByUserId(123);

        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("Should be fail and return basket with match userId")
    void findByUserIdFail() {
        // Arrange

        // Act
        Optional<Basket> result = basketRepository.findByUserId(123);

        // Assert
        assertTrue(result.isEmpty());
    }
}