package com.example.ecommerce.user.services;

import com.example.ecommerce.user.exceptions.UserNotFoundException;
import com.example.ecommerce.user.models.GetUserResponse;
import com.example.ecommerce.user.repositories.UserRepository;
import com.example.ecommerce.user.repositories.entities.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Should be success get user id 1")
    void getUserSuccess() {
        // Arrange
        User userMock = new User();
        userMock.setId(1);
        when(userRepository.findById(1)).thenReturn(Optional.of(userMock));

        // Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);
        GetUserResponse userResponse = userService.getUser(1);

        // Assert
        assertEquals(1,userResponse.getId());
    }

    @Test
    @DisplayName("Should be fail when user return empty")
    void getUserFail() {
        // Arrange

        // Act
        UserService userService = new UserService();
        userService.setUserRepository(userRepository);

        // Assert
        assertThrows(UserNotFoundException.class,()->userService.getUser(1));
    }
}