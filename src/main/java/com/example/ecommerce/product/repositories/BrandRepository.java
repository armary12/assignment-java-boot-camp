package com.example.ecommerce.product.repositories;

import com.example.ecommerce.product.repositories.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
