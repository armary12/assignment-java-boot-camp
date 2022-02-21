package com.example.ecommerce.product.repositories;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private String description;
    private int price;
    private int discount_percent;
    private String promotion_end_date;
    private int isDeliveryDiscount;
    private int product_model_id;
    private int size_id;
    private String primary_image;
    private List<String> secondary_images;
    private int brand_id;
    private int shop_id;
    private String status;
    private String created_date;
    private String updated_date;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount_percent() {
        return discount_percent;
    }

    public void setDiscount_percent(int discount_percent) {
        this.discount_percent = discount_percent;
    }

    public String getPromotion_end_date() {
        return promotion_end_date;
    }

    public void setPromotion_end_date(String promotion_end_date) {
        this.promotion_end_date = promotion_end_date;
    }

    public int getIsDeliveryDiscount() {
        return isDeliveryDiscount;
    }

    public void setIsDeliveryDiscount(int isDeliveryDiscount) {
        this.isDeliveryDiscount = isDeliveryDiscount;
    }

    public int getProduct_model_id() {
        return product_model_id;
    }

    public void setProduct_model_id(int product_model_id) {
        this.product_model_id = product_model_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public String getPrimary_image() {
        return primary_image;
    }

    public void setPrimary_image(String primary_image) {
        this.primary_image = primary_image;
    }

    public List<String> getSecondary_images() {
        return secondary_images;
    }

    public void setSecondary_images(List<String> secondary_images) {
        this.secondary_images = secondary_images;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }
}
