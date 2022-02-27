package com.example.ecommerce.product.models;

import lombok.Data;

@Data
public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private int price;
    private int discountPercent;
    private int netPrice;
    private String promotionEndDate;
    private int isDeliveryDiscount;
    private String productModelName;
    private String primaryImage;
    private String[] secondaryImages;
    private String brandName;
    private String shopName;
    private String ShopProvince;
    private String status;
    private String[] sizes;
    private int score;
    private int reviewerCount;

    public ProductResponse(){}
}
