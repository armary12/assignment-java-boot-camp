package com.example.ecommerce.order.controllers;

import com.example.ecommerce.order.models.OrderConfirmRequest;
import com.example.ecommerce.order.repositories.entities.OrderTransaction;
import com.example.ecommerce.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("api/v1/order/confirm")
    public OrderTransaction confirmOrder(@RequestBody OrderConfirmRequest orderConfirmRequest){
        return orderService.createOrderTransaction(orderConfirmRequest);
    }
}
