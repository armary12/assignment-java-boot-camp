package com.example.ecommerce.order.services;

import com.example.ecommerce.order.exceptions.PaymentFailException;
import com.example.ecommerce.order.gateways.PaymentGateway;
import com.example.ecommerce.order.models.OrderConfirmRequest;
import com.example.ecommerce.order.models.OrderItem;
import com.example.ecommerce.order.models.PaymentGatewayRequest;
import com.example.ecommerce.order.models.PaymentGatewayResponse;
import com.example.ecommerce.order.repositories.OrderTransactionItemRepository;
import com.example.ecommerce.order.repositories.OrderTransactionRepository;
import com.example.ecommerce.order.repositories.entities.OrderTransaction;
import com.example.ecommerce.order.repositories.entities.OrderTransactionItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    OrderTransactionRepository orderTransactionRepository;
    @Autowired
    OrderTransactionItemRepository orderTransactionItemRepository;
    @Autowired
    PaymentGateway paymentGateway;


    public OrderTransaction createOrderTransaction(OrderConfirmRequest orderTransactionRequest){
        OrderTransaction createOrderTransaction = new OrderTransaction();
        createOrderTransaction.setNetPrice(orderTransactionRequest.getNetPrice());
        createOrderTransaction.setDeliveryPrice(orderTransactionRequest.getDeliveryPrice());
        createOrderTransaction.setTotalItemPrice(orderTransactionRequest.getTotalItemPrice());
        createOrderTransaction.setTotalItemQuantity(orderTransactionRequest.getTotalItemQuantity());
        createOrderTransaction.setUserId(orderTransactionRequest.getUserId());
        createOrderTransaction.setDeliveryAddress(orderTransactionRequest.getDeliveryAddress());
        createOrderTransaction.setPaymentDetail(orderTransactionRequest.getPaymentDetail());
        createOrderTransaction.setPromotionDetail(orderTransactionRequest.getPromotionDetail());
        createOrderTransaction.setShippingDetail(orderTransactionRequest.getShippingDetail());
        createOrderTransaction.setCreatedDate(new Date());
        createOrderTransaction.setOrderStatus("PENDING");

        List<OrderTransactionItem> orderTransactionItemList = new ArrayList<>();
        for (OrderItem orderItem : orderTransactionRequest.getOrderItems()) {
            OrderTransactionItem orderTransactionItem = new OrderTransactionItem();
            orderTransactionItem.setPrice(orderItem.getPrice());
            orderTransactionItem.setQuantity(orderItem.getQuantity());
            orderTransactionItem.setProductId(orderItem.getProductId());
            orderTransactionItem.setTotalPrice(orderItem.getTotalPrice());
            orderTransactionItem.setCreatedDate(new Date());
            orderTransactionItemList.add(orderTransactionItem);
        }
        createOrderTransaction.setOrderTransactionItems(orderTransactionItemList);
        OrderTransaction orderTransaction = orderTransactionRepository.save(createOrderTransaction);

        PaymentGatewayRequest paymentGatewayRequest = new PaymentGatewayRequest();
        paymentGatewayRequest.setOrderId(orderTransaction.getId());
        paymentGatewayRequest.setCardHolderName(orderTransactionRequest.getPaymentDetail().getCardHolderName());
        paymentGatewayRequest.setUserId(orderTransactionRequest.getUserId());
        paymentGatewayRequest.setCardType(orderTransactionRequest.getPaymentDetail().getCardType());
        paymentGatewayRequest.setCardNumber(orderTransactionRequest.getPaymentDetail().getCardNumber());
        paymentGatewayRequest.setExpiredDate(orderTransactionRequest.getPaymentDetail().getExpiredDate());
        paymentGatewayRequest.setTotalAmount(orderTransactionRequest.getNetPrice());
        PaymentGatewayResponse paymentGatewayResponse =  paymentGateway.submitPayment(paymentGatewayRequest);

        if (paymentGatewayResponse.getStatusMessage() == "success") {
            Optional<OrderTransaction> orderTransactionOptional =  orderTransactionRepository.findById(orderTransaction.getId());
            if (orderTransactionOptional.isPresent()){
                OrderTransaction updateOrderTransaction = orderTransactionOptional.get();
                updateOrderTransaction.setOrderStatus("SUCCESS");
                orderTransactionRepository.save(updateOrderTransaction);
            } else {
                throw new PaymentFailException("Payment fail");
            }
        }
        return orderTransaction;
    }
}
