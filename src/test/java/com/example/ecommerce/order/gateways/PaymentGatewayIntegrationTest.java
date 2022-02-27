package com.example.ecommerce.order.gateways;

import com.example.ecommerce.order.models.PaymentGatewayRequest;
import com.example.ecommerce.order.models.PaymentGatewayResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentGatewayIntegrationTest {

    @Autowired
    private PaymentGateway paymentGateway;

    @Test
    void submitPayment() {
        // Act
        PaymentGatewayRequest paymentGatewayRequest = new PaymentGatewayRequest();
        PaymentGatewayResponse result = paymentGateway.submitPayment(paymentGatewayRequest);

        // Assert
        assertEquals(101,result.getResponseCode());
    }
}