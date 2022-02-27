package com.example.ecommerce.user.controllers;

import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.user.models.GetUserResponse;
import com.example.ecommerce.user.services.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {


    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserService userService;

    @Test
    @DisplayName("Should be success return product with id = 1 when receive input productId = 1")
    void getUserSuccess() {
        // Arrange
        GetUserResponse getUserResponse = new GetUserResponse();
        getUserResponse.setId(1);
        when(userService.getUser(1)).thenReturn(getUserResponse);

        // Act
        ResponseModel<ProductResponse> result = testRestTemplate.getForObject("/api/v1/user/1", ResponseModel.class);
        ObjectMapper mapper = new ObjectMapper();
        GetUserResponse userResponse = mapper.convertValue(result.getData(), new TypeReference<GetUserResponse>() {
        });

        // Assert
        assertEquals("success", result.getMessage());
        assertEquals(1, userResponse.getId());
    }
}