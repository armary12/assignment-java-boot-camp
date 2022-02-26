package com.example.ecommerce.order.repositories;

import com.example.ecommerce.order.repositories.entities.OrderTransactionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTransactionItemRepository extends JpaRepository<OrderTransactionItem, Integer> {
}
