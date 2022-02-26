package com.example.ecommerce.product.repositories.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Shop {
    @Id
    private int id;
    private String name;
    private String description;
    private String logo_path;
    private String website_url;
    private String status;
    private String province;
    private Date createdDate;
    private Date updatedDate;

    public Shop(){}

    public Shop(int id, String name, String description, String province, String logo_path, String website_url, String status, Date createdDate, Date updatedDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.province = province;
        this.logo_path = logo_path;
        this.website_url = website_url;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
