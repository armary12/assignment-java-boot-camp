package com.example.ecommerce.product.repositories;

import com.example.ecommerce.product.repositories.entities.*;
import com.example.ecommerce.user.repositories.UserRepository;
import com.example.ecommerce.user.repositories.entities.User;
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
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("Should be success query product by id = 1")
    void findByIdSuccess() {
        // Arrange
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Adidas Yeezy Boost 350 V2 Beluga 2.0(AH2203)", "สวมใส่สะบาย",39900,28,"2022-10-10",0,1,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null, new String[]{"36","37","38"}));
        productRepository.saveAll(productList);

        // Act
        Optional<Product> result = productRepository.findById(1);

        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("Should be fail query product by id = 1 when there is no data")
    void findByIdFail() {
        // Act
        Optional<Product> result = productRepository.findById(999);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Should be success query all product with name searched")
    void findByNameContainingSuccess() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Adidas Yeezy Boost 350 V2 Beluga 2.0(AH2203)", "สวมใส่สะบาย",39900,28,"2022-10-10",0,1,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null, new String[]{"36","37","38"}));
        productRepository.saveAll(productList);

        // Act
        List<Product> result = productRepository.findByNameContaining("Adidas");

        // Assert
        assertTrue(result.size() > 0);
    }

    @Test
    @DisplayName("Should be success search product when there is no data match")
    void findByNameContainingFail() {
        // Act
        List<Product> result = productRepository.findByNameContaining("test");
        System.out.println(result);
        // Assert
        assertTrue(result.size() == 0);
    }
}