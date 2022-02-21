package com.example.ecommerce.product.repositories;

import com.example.ecommerce.product.repositories.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//    @Query("Select p from Product p left join Brand b where p.brandId = b.id")
    Optional<Product> findById(int id);

}
