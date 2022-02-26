package com.example.ecommerce.user.repositories;

import com.example.ecommerce.user.repositories.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
