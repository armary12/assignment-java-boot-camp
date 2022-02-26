package com.example.ecommerce.user.controllers;

import com.example.ecommerce.user.models.GetUserResponse;
import com.example.ecommerce.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("api/v1/user/{userId}")
    public GetUserResponse getUser(@PathVariable int userId){
        return userService.getUser(userId);
    }
}
