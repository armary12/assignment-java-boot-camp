package com.example.ecommerce.order.repositories;

import com.example.ecommerce.order.repositories.entities.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Integer> {
}
