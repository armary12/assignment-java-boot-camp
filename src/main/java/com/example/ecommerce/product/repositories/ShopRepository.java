package com.example.ecommerce.product.repositories;

import com.example.ecommerce.product.repositories.entities.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
