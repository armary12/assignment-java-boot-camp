package com.example.ecommerce.order.services;

import com.example.ecommerce.order.models.OrderConfirmRequest;
import com.example.ecommerce.order.models.OrderItem;
import com.example.ecommerce.order.repositories.OrderTransactionItemRepository;
import com.example.ecommerce.order.repositories.OrderTransactionRepository;
import com.example.ecommerce.order.repositories.entities.OrderTransaction;
import com.example.ecommerce.order.repositories.entities.OrderTransactionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderTransactionRepository orderTransactionRepository;
    @Autowired
    OrderTransactionItemRepository orderTransactionItemRepository;

    public OrderTransaction createOrderTransaction(OrderConfirmRequest orderTransactionRequest){
        OrderTransaction createOrderTransaction = new OrderTransaction();
        createOrderTransaction.setNetPrice(orderTransactionRequest.getNetPrice());
        createOrderTransaction.setDeliveryPrice(orderTransactionRequest.getDeliveryPrice());
        createOrderTransaction.setTotalItemPrice(orderTransactionRequest.getTotalItemPrice());
        createOrderTransaction.setTotalItemQuantity(orderTransactionRequest.getTotalItemQuantity());
        createOrderTransaction.setUserId(orderTransactionRequest.getUserId());
        createOrderTransaction.setDeliveryAddress(orderTransactionRequest.getDeliveryAddress());
        createOrderTransaction.setPromotionDetail(orderTransactionRequest.getPromotionDetail());
        createOrderTransaction.setShippingDetail(orderTransactionRequest.getShippingDetail());
        createOrderTransaction.setCreatedDate(new Date());
        OrderTransaction orderTransaction = orderTransactionRepository.save(createOrderTransaction);

        List<OrderTransactionItem> orderTransactionItemList = new ArrayList<>();
        for (OrderItem orderItem : orderTransactionRequest.getOrderItems()) {
            OrderTransactionItem orderTransactionItem = new OrderTransactionItem();
            orderTransactionItem.setOrderTransactionId(orderTransaction.getId());
            orderTransactionItem.setPrice(orderItem.getPrice());
            orderTransactionItem.setQuantity(orderItem.getQuantity());
            orderTransactionItem.setProductId(orderItem.getProductId());
            orderTransactionItem.setTotalPrice(orderItem.getTotalPrice());
            orderTransactionItem.setCreatedDate(new Date());
            orderTransactionItemList.add(orderTransactionItem);
        }
        orderTransactionItemRepository.saveAll(orderTransactionItemList);

        return orderTransaction;
    }
}
