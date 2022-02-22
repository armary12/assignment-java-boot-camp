package com.example.ecommerce.product.repositories.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class ProductModel {
    @Id
    private int id;
    private String name;
    private String status;
    private Date createdDate;
    private Date updatedDate;

    public ProductModel(){}

    public ProductModel(int id, String name, String status, Date createdDate, Date updatedDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
