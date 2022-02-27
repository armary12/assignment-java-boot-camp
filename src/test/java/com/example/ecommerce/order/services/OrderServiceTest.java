package com.example.ecommerce.order.services;

import com.example.ecommerce.order.exceptions.PaymentFailException;
import com.example.ecommerce.order.gateways.PaymentGateway;
import com.example.ecommerce.order.models.OrderConfirmRequest;
import com.example.ecommerce.order.models.OrderItem;
import com.example.ecommerce.order.models.PaymentGatewayResponse;
import com.example.ecommerce.order.repositories.OrderTransactionRepository;
import com.example.ecommerce.order.repositories.entities.OrderTransaction;
import com.example.ecommerce.order.repositories.entities.PaymentDetail;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.product.repositories.ProductRepository;
import com.example.ecommerce.product.services.ProductService;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderTransactionRepository orderTransactionRepository;

    @Mock
    private PaymentGateway paymentGateway;

    @Test
    @DisplayName("Should be success when payment gate way return 101")
    void createOrderTransaction() {
        // Arrange
        OrderConfirmRequest orderConfirmRequest = new OrderConfirmRequest();
        OrderItem[] orderItemList = new OrderItem[]{};
        PaymentDetail paymentDetail = new PaymentDetail();
        orderConfirmRequest.setOrderItems(orderItemList);
        orderConfirmRequest.setPaymentDetail(paymentDetail);
        orderConfirmRequest.setUserId(123);

        OrderTransaction orderTransactionMock = new OrderTransaction();
        orderTransactionMock.setId(1);
        orderTransactionMock.setUserId(123);
        when(orderTransactionRepository.save(any())).thenReturn(orderTransactionMock);

        PaymentGatewayResponse paymentGatewayResponse = new PaymentGatewayResponse();
        paymentGatewayResponse.setResponseCode(101);
        when(paymentGateway.submitPayment(any())).thenReturn(paymentGatewayResponse);

        // Act
        OrderService orderService = new OrderService();
        orderService.setOrderTransactionRepository(orderTransactionRepository);
        orderService.setPaymentGateway(paymentGateway);
        OrderTransaction orderTransaction = orderService.createOrderTransaction(orderConfirmRequest);

        // Assert
        assertEquals(123, orderTransaction.getUserId());
    }

    @Test
    @DisplayName("Should be success when payment gate way return != 101")
    void createOrderTransactionFail() {
        // Arrange
        OrderConfirmRequest orderConfirmRequest = new OrderConfirmRequest();
        OrderItem[] orderItemList = new OrderItem[]{};
        PaymentDetail paymentDetail = new PaymentDetail();
        orderConfirmRequest.setOrderItems(orderItemList);
        orderConfirmRequest.setPaymentDetail(paymentDetail);
        orderConfirmRequest.setUserId(123);

        OrderTransaction orderTransactionMock = new OrderTransaction();
        orderTransactionMock.setId(1);
        orderTransactionMock.setUserId(123);
        when(orderTransactionRepository.save(any())).thenReturn(orderTransactionMock);

        PaymentGatewayResponse paymentGatewayResponse = new PaymentGatewayResponse();
        paymentGatewayResponse.setResponseCode(102);
        when(paymentGateway.submitPayment(any())).thenReturn(paymentGatewayResponse);

        // Act
        OrderService orderService = new OrderService();
        orderService.setOrderTransactionRepository(orderTransactionRepository);
        orderService.setPaymentGateway(paymentGateway);

        // Assert
        assertThrows(PaymentFailException.class,() -> orderService.createOrderTransaction(orderConfirmRequest));
    }

}