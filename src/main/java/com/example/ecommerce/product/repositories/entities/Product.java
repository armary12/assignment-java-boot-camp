package com.example.ecommerce.product.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
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

    @ManyToOne(optional=false)
    @JoinColumn(name = "brand_id", insertable=false, updatable=false)
    private Brand brand;

    @ManyToOne(optional=false)
    @JoinColumn(name = "shop_id", insertable=false, updatable=false)
    private Shop shop;

    @ManyToOne(optional=false)
    @JoinColumn(name = "product_model_id", insertable=false, updatable=false)
    private ProductModel productModel;

    @OneToMany(mappedBy="product_id")
    private List<ProductReview> productReviews;

    public Product(){}

    public Product(int id, String name, String description, int price, int discountPercent, String promotionEndDate, int isDeliveryDiscount, int productModelId, int sizeId, String primaryImage, String[] secondaryImages, int brandId, int shopId, String status, Date createdDate, Date updatedDate, String[] sizes) {
        this.id =id;
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
}
