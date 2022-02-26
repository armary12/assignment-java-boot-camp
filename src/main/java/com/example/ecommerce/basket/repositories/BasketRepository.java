package com.example.ecommerce.basket.repositories;

import com.example.ecommerce.basket.repositories.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Optional<Basket> findByUserId(int userId);
}
