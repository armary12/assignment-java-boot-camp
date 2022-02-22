package com.example.ecommerce.product.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getReviewerCount() {
        return reviewerCount;
    }

    public void setReviewerCount(int reviewerCount) {
        this.reviewerCount = reviewerCount;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public String getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(String promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public int getIsDeliveryDiscount() {
        return isDeliveryDiscount;
    }

    public void setIsDeliveryDiscount(int isDeliveryDiscount) {
        this.isDeliveryDiscount = isDeliveryDiscount;
    }

    public String getProductModelName() {
        return productModelName;
    }

    public void setProductModelName(String productModelName) {
        this.productModelName = productModelName;
    }

    public String getPrimaryImage() {
        return primaryImage;
    }

    public void setPrimaryImage(String primaryImage) {
        this.primaryImage = primaryImage;
    }

    public String[] getSecondaryImages() {
        return secondaryImages;
    }

    public void setSecondaryImages(String[] secondaryImages) {
        this.secondaryImages = secondaryImages;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopProvince() {
        return ShopProvince;
    }

    public void setShopProvince(String shopProvince) {
        ShopProvince = shopProvince;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getSizes() {
        return sizes;
    }

    public void setSizes(String[] sizes) {
        this.sizes = sizes;
    }
}
