package com.example.ecommerce.product.repositories;

import com.example.ecommerce.product.repositories.entities.*;
import com.example.ecommerce.user.repositories.UserRepository;
import com.example.ecommerce.user.repositories.entities.User;
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
    void findByIdFail() {
        // Act
        Optional<Product> result = productRepository.findById(1);

        // Assert
        assertTrue(result.isPresent());
    }

    @Test
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
    void findByNameContainingFail() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Adidas Yeezy Boost 350 V2 Beluga 2.0(AH2203)", "สวมใส่สะบาย",39900,28,"2022-10-10",0,1,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null, new String[]{"36","37","38"}));
        productRepository.saveAll(productList);
        // Act
        List<Product> result = productRepository.findByNameContaining("Adidas");

        // Assert
        assertTrue(result.size() > 0);
    }
}