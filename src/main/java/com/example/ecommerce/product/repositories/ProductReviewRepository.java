package com.example.ecommerce.product.repositories;

import com.example.ecommerce.product.repositories.entities.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Integer> {
}
