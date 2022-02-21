package com.example.ecommerce.product.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
