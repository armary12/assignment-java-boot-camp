package com.example.ecommerce.order.repositories.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class OrderTransaction {
    @Id
    @GeneratedValue
    private int id;
    private int netPrice;
    private int deliveryPrice;
    private int totalItemPrice;
    private int totalItemQuantity;
    private int userId;
    private String deliveryAddress;
    private String orderStatus;
    private Date CreatedDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_detail_id", referencedColumnName = "id")
    private PaymentDetail paymentDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_detail_id", referencedColumnName = "id")
    private ShippingDetail shippingDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "promotion_detail_id", referencedColumnName = "id")
    private PromotionDetail promotionDetail;

    @OneToMany(mappedBy = "orderTransaction", fetch = FetchType.EAGER)
    private List<OrderTransactionItem> OrderTransactionItems;

}
