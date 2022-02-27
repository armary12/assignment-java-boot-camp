package com.example.ecommerce.user.repositories;

import com.example.ecommerce.user.repositories.entities.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("Should be success query user by id = 1")
    void findByIdSuccess() {
        // Arrange
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "Chonlatid", "Jitbute","MALE","16 Charoemprakiet Rama 9 45 yak 2 Nongbon Pravet Bangkok", "10250", "16 Charoemprakiet Rama 9 45 yak 2 Nongbon Pravet Bangkok","10250","0987654321","chonlaird.jit@gmail.com",1,"ACTIVE",new Date(), null));
        userRepository.saveAll(userList);

        // Act
        Optional<User> result = userRepository.findById(1);

        // Assert
        assertTrue(result.isPresent());
    }

    @Test
    @DisplayName("Should be success query user by id = 1")
    void findByIdFail() {
        // Act
        Optional<User> result = userRepository.findById(1);

        // Assert
        assertTrue(result.isPresent());
    }
}