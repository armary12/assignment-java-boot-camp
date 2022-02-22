package com.example.ecommerce.product.repositories.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class ProductReview {
    @Id
    @GeneratedValue
    private int id;
    private int product_id;
    private int score;
    private String review;
    private String status;
    private Date createdDate;
    private Date updatedDate;

    public ProductReview(){}

    public ProductReview(int product_id, int score, String review, String status, Date createdDate, Date updatedDate) {
        this.product_id = product_id;
        this.score = score;
        this.review = review;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
