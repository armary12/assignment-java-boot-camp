package com.example.ecommerce.product.repositories.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Product {
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="price")
    private int price;
    @Column(name="discount_percent")
    private int discountPercent;
    @Column(name="promotion_end_date")
    private String promotionEndDate;
    @Column(name="is_delivery_discount")
    private int isDeliveryDiscount;
    @Column(name="product_model_id")
    private int productModelId;
    @Column(name="size_id")
    private int sizeId;
    @Column(name="primary_image")
    private String primaryImage;
    @Column(name="secondary_image")
    private String[] secondaryImages;
    @Column(name="brand_id")
    private int brandId;
    @Column(name="shop_id")
    private int shopId;
    @Column(name="status")
    private String status;
    @Column(name="created_date")
    private Date createdDate;
    @Column(name="updated_date")
    private Date updatedDate;
    @Column(name="size")
    private String[] sizes;

    public Product(){}

    public Product(int id, String name, String description, int price, int discountPercent, String promotionEndDate, int isDeliveryDiscount, int productModelId, int sizeId, String primaryImage, String[] secondaryImages, int brandId, int shopId, String status, Date createdDate, Date updatedDate, String[] sizes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discountPercent = discountPercent;
        this.promotionEndDate = promotionEndDate;
        this.isDeliveryDiscount = isDeliveryDiscount;
        this.productModelId = productModelId;
        this.sizeId = sizeId;
        this.primaryImage = primaryImage;
        this.secondaryImages = secondaryImages;
        this.brandId = brandId;
        this.shopId = shopId;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.sizes = sizes;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name = "brand_id", insertable=false, updatable=false)
    private Brand brand;

    @ManyToOne(optional=false)
    @JoinColumn(name = "shop_id", insertable=false, updatable=false)
    private Shop shop;

    @ManyToOne(optional=false)
    @JoinColumn(name = "product_model_id", insertable=false, updatable=false)
    private ProductModel productModel;

    public void setSizes(String[] sizes) {
        this.sizes = sizes;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public String[] getSizes() {
        return sizes;
    }

    public void setSize(String[] sizes) {
        this.sizes = sizes;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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

    public int getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(int productModelId) {
        this.productModelId = productModelId;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
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

    public void setSecondaryImages(String[]  secondaryImages) {
        this.secondaryImages = secondaryImages;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
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
