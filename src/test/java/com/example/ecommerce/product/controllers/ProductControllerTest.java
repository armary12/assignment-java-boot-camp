package com.example.ecommerce.product.controllers;

import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.product.exceptions.ProductNotFoundException;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.product.services.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ProductService productService;

    @Test
    @DisplayName("Should be success return product with id = 1 when receive input productId = 1")
    void getProductByIdSuccess() {
        // Arrange
        ProductResponse productResponse = new ProductResponse() ;
        productResponse.setId(1);
        when(productService.getProductById(1)).thenReturn(productResponse);

        // Act
        ResponseModel<ProductResponse> result = testRestTemplate.getForObject("/api/v1/product/1", ResponseModel.class);
        ObjectMapper mapper = new ObjectMapper();
        ProductResponse product = mapper.convertValue(result.getData(), new TypeReference<ProductResponse>() {
        });

        // Assert
        assertEquals("success", result.getMessage());
        assertEquals(1, product.getId());
    }

    @Test
    @DisplayName("Should return 'Product not found' when receive input productId = 9999")
    void getProductByIdFail() {
        // Arrange
        ProductResponse productResponse = new ProductResponse() ;
        productResponse.setId(1);
        when(productService.getProductById(99)).thenThrow(new ProductNotFoundException("Product not found"));

        // Act
        ResponseModel<ProductResponse> result = testRestTemplate.getForObject("/api/v1/product/99", ResponseModel.class);

        // Assert
        assertEquals("Product not found", result.getMessage());
    }

    @Test
    @DisplayName("Should return products with element more than 0")
    void getProductsSuccess() {
        // Arrange
        List<ProductResponse> productsResponse = new ArrayList<>() ;
        ProductResponse productResponse = new ProductResponse() ;
        productResponse.setId(1);
        productsResponse.add(productResponse);
        when(productService.getProducts(null)).thenReturn(productsResponse);

        // Act
        ResponseModel<List<ProductResponse>> result = testRestTemplate.getForObject("/api/v1/product", ResponseModel.class);

        ObjectMapper mapper = new ObjectMapper();
        List<ProductResponse> products = mapper.convertValue(result.getData(), new TypeReference<List<ProductResponse>>() {
        });

        // Assert
        assertEquals("success", result.getMessage());
        assertTrue(products.size() > 0);
    }
}