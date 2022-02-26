package com.example.ecommerce.order.gateways;

import com.example.ecommerce.order.models.PaymentGatewayRequest;
import com.example.ecommerce.order.models.PaymentGatewayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PaymentGateway {

    @Autowired
    private RestTemplate restTemplate;

    private String paymentGateWayEndpoint;

    public PaymentGateway(@Value("${PAYMENT_GATEWAY_ENDPOINT}") String paymentGateWayEndpoint) {
        this.paymentGateWayEndpoint = paymentGateWayEndpoint;
    }

    public PaymentGatewayResponse submitPayment(PaymentGatewayRequest request) {

        PaymentGatewayResponse paymentGatewayResponse = restTemplate.postForObject(paymentGateWayEndpoint, request, PaymentGatewayResponse.class);
        return paymentGatewayResponse;
    }
}
