package com.example.ecommerce.product.repositories.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo_path() {
        return logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
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
