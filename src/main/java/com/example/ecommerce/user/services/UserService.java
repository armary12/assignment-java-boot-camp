package com.example.ecommerce.user.services;

import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.user.exceptions.UserNotFoundException;
import com.example.ecommerce.user.models.GetUserResponse;
import com.example.ecommerce.user.repositories.UserRepository;
import com.example.ecommerce.user.repositories.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public GetUserResponse getUser(int userId){
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found.");
        }
        User user = userOptional.get();
        GetUserResponse userResponse = new GetUserResponse();
        userResponse.setId(user.getId());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setGender(user.getGender());
        userResponse.setAddress(user.getAddress());
        userResponse.setPostalCode(user.getPostalCode());
        userResponse.setVatAddress(user.getVatAddress());
        userResponse.setVatPostalCode(user.getPostalCode());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setNewsSubscription(user.getNewsSubscription());
        userResponse.setStatus(user.getStatus());
        return userResponse;
    }
}
