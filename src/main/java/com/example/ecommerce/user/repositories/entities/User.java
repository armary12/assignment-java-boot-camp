package com.example.ecommerce.user.repositories.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
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
    private Date createdDate;
    private Date updateDate;

    public User(){};

    public User(int id, String firstName, String lastName, String gender, String address, String postalCode, String vatAddress, String vatPostalCode, String phone, String email, int newsSubscription, String status, Date createdDate, Date updateDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.postalCode = postalCode;
        this.vatAddress = vatAddress;
        this.vatPostalCode = vatPostalCode;
        this.phone = phone;
        this.email = email;
        this.newsSubscription = newsSubscription;
        this.status = status;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }
}
