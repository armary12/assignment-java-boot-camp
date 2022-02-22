package com.example.ecommerce.product.repositories;

import com.example.ecommerce.product.repositories.entities.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductModelRepository extends JpaRepository<ProductModel, Integer> {
}
