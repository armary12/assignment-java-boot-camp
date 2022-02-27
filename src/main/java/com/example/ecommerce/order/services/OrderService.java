package com.example.ecommerce.order.services;

import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.order.exceptions.PaymentFailException;
import com.example.ecommerce.order.gateways.PaymentGateway;
import com.example.ecommerce.order.models.OrderConfirmRequest;
import com.example.ecommerce.order.models.OrderItem;
import com.example.ecommerce.order.models.PaymentGatewayRequest;
import com.example.ecommerce.order.models.PaymentGatewayResponse;
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
    PaymentGateway paymentGateway;


    public OrderTransaction createOrderTransaction(OrderConfirmRequest orderTransactionRequest) {
        OrderTransaction orderTransaction = saveOrderTransaction(orderTransactionRequest);
        validatePayment(orderTransaction.getId(), orderTransactionRequest);
        return orderTransaction;
    }

    private OrderTransaction saveOrderTransaction(OrderConfirmRequest request) {
        OrderTransaction createOrderTransaction = new OrderTransaction();
        createOrderTransaction.setNetPrice(request.getNetPrice());
        createOrderTransaction.setDeliveryPrice(request.getDeliveryPrice());
        createOrderTransaction.setTotalItemPrice(request.getTotalItemPrice());
        createOrderTransaction.setTotalItemQuantity(request.getTotalItemQuantity());
        createOrderTransaction.setUserId(request.getUserId());
        createOrderTransaction.setDeliveryAddress(request.getDeliveryAddress());
        createOrderTransaction.setPaymentDetail(request.getPaymentDetail());
        createOrderTransaction.setPromotionDetail(request.getPromotionDetail());
        createOrderTransaction.setShippingDetail(request.getShippingDetail());
        createOrderTransaction.setCreatedDate(new Date());
        createOrderTransaction.setOrderStatus("PENDING");

        List<OrderTransactionItem> orderTransactionItemList = new ArrayList<>();
        for (OrderItem orderItem : request.getOrderItems()) {
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
        return orderTransaction;
    }

    private void validatePayment(int orderTransactionId, OrderConfirmRequest request) {
        PaymentGatewayRequest paymentGatewayRequest = mapPaymentGatewayRequest(orderTransactionId, request);
        PaymentGatewayResponse paymentGatewayResponse = paymentGateway.submitPayment(paymentGatewayRequest);
        if (paymentGatewayResponse.getResponseCode() == 101) {
            Optional<OrderTransaction> orderTransactionOptional = orderTransactionRepository.findById(orderTransactionId);
            if (orderTransactionOptional.isPresent()) {
                OrderTransaction updateOrderTransaction = orderTransactionOptional.get();
                updateOrderTransaction.setOrderStatus("SUCCESS");
                orderTransactionRepository.save(updateOrderTransaction);
            }
        } else {
            throw new PaymentFailException("Payment fail");
        }

    }

    private PaymentGatewayRequest mapPaymentGatewayRequest(int orderTransactionId, OrderConfirmRequest request) {
        PaymentGatewayRequest paymentGatewayRequest = new PaymentGatewayRequest();
        paymentGatewayRequest.setOrderId(orderTransactionId);
        paymentGatewayRequest.setCardHolderName(request.getPaymentDetail().getCardHolderName());
        paymentGatewayRequest.setUserId(request.getUserId());
        paymentGatewayRequest.setCardType(request.getPaymentDetail().getCardType());
        paymentGatewayRequest.setCardNumber(request.getPaymentDetail().getCardNumber());
        paymentGatewayRequest.setExpiredDate(request.getPaymentDetail().getExpiredDate());
        paymentGatewayRequest.setTotalAmount(request.getNetPrice());
        return paymentGatewayRequest;
    }
}
