package com.example.ecommerce.product.services;

import com.example.ecommerce.landing.models.LandingResponse;
import com.example.ecommerce.product.repositories.ProductRepository;
import com.example.ecommerce.product.repositories.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(int id) {
        Optional<Product> productRes = productRepository.findById(id);
        return productRes.get();
    }
}
