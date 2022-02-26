package com.example.ecommerce.basket.repositories;

import com.example.ecommerce.basket.repositories.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
}
