package com.example.ecommerce.product.repositories;

import com.example.ecommerce.product.repositories.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findById(int id);

}
