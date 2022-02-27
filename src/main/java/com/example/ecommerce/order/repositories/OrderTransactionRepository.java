package com.example.ecommerce.order.repositories;

import com.example.ecommerce.order.repositories.entities.OrderTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTransactionRepository extends JpaRepository<OrderTransaction, Integer> {
}
