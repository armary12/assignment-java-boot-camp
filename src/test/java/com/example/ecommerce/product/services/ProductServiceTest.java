package com.example.ecommerce.product.services;

import com.example.ecommerce.product.exceptions.ProductNotFoundException;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.product.repositories.ProductRepository;
import com.example.ecommerce.product.repositories.entities.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("Should return product id 1 when input productId = 1")
    void getProductByIdSuccess() {
        // Arrange
        Product product = new Product() ;
        ProductModel productModel = new ProductModel();
        Brand brand = new Brand();
        Shop shop = new Shop();
        List<ProductReview> productReviews = new ArrayList<>();
        ProductReview productReview = new ProductReview();
        productReviews.add(productReview);

        product.setId(1);
        product.setProductModel(productModel);
        product.setBrand(brand);
        product.setShop(shop);
        product.setProductReviews(productReviews);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        ProductResponse productResponse = productService.getProductById(1);

        // Assert
        assertEquals(1, productResponse.getId());
    }

    @Test
    @DisplayName("Should throw ProductNotFound exception when product is not found")
    void getProductByIdFail() {
        // Arrange

        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);

        // Assert
        assertThrows(ProductNotFoundException.class,() -> productService.getProductById(1));
    }

    @Test
    @DisplayName("Should return list of products with size 1")
    void getProductsSuccess() {
        // Arrange
        List<Product> products = new ArrayList<>();
        Product product = new Product() ;
        ProductModel productModel = new ProductModel();
        Brand brand = new Brand();
        Shop shop = new Shop();
        List<ProductReview> productReviews = new ArrayList<>();
        ProductReview productReview = new ProductReview();
        productReviews.add(productReview);

        product.setId(1);
        product.setProductModel(productModel);
        product.setBrand(brand);
        product.setShop(shop);
        product.setProductReviews(productReviews);
        products.add(product);
        when(productRepository.findAll()).thenReturn(products);

        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> productsResponse = productService.getProducts(null);

        // Assert
        assertEquals(1, productsResponse.size());
    }

    @Test
    @DisplayName("Should return list of products with size 1 when input search query")
    void getProductsWithSearchSuccess() {
        // Arrange
        List<Product> products = new ArrayList<>();
        Product product = new Product() ;
        ProductModel productModel = new ProductModel();
        Brand brand = new Brand();
        Shop shop = new Shop();
        List<ProductReview> productReviews = new ArrayList<>();

        product.setId(1);
        product.setProductModel(productModel);
        product.setBrand(brand);
        product.setShop(shop);
        product.setProductReviews(productReviews);
        products.add(product);
        when(productRepository.findByNameContaining("test")).thenReturn(products);

        // Act
        ProductService productService = new ProductService();
        productService.setProductRepository(productRepository);
        List<ProductResponse> productsResponse = productService.getProducts("test");

        // Assert
        assertEquals(1, productsResponse.size());
    }
}