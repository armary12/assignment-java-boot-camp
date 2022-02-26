package com.example.ecommerce.user.models;

import lombok.Data;

@Data
public class GetUserResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String postalCode;
    private String vatAddress;
    private String vatPostalCode;
    private String phone;
    private String email;
    private int newsSubscription;
    private String status;

}
