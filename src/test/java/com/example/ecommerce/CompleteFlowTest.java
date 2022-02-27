package com.example.ecommerce;

import com.example.ecommerce.basket.models.BasketItem;
import com.example.ecommerce.basket.models.CreateBasketRequest;
import com.example.ecommerce.basket.models.GetBasketResponse;
import com.example.ecommerce.basket.repositories.entities.Basket;
import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.order.models.OrderConfirmRequest;
import com.example.ecommerce.order.models.OrderItem;
import com.example.ecommerce.order.repositories.entities.OrderTransaction;
import com.example.ecommerce.order.repositories.entities.PaymentDetail;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.user.models.GetUserResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompleteFlowTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    @DisplayName("Should be success and complete flow")
    void completeFlowSuccess() {
        ObjectMapper mapper = new ObjectMapper();

        // Arrange
        CreateBasketRequest createBasketRequest = new CreateBasketRequest();
        createBasketRequest.setUserId(1);
        createBasketRequest.setBasketItems(new BasketItem[]{});

        OrderConfirmRequest orderConfirmRequest = new OrderConfirmRequest();
        OrderItem[] orderItemList = new OrderItem[]{};
        PaymentDetail paymentDetail = new PaymentDetail();
        orderConfirmRequest.setOrderItems(orderItemList);
        orderConfirmRequest.setPaymentDetail(paymentDetail);
        orderConfirmRequest.setUserId(1);

        // Act
        ResponseModel<List<ProductResponse>> allProductsResponse = testRestTemplate.getForObject("/api/v1/product", ResponseModel.class);
        List<ProductResponse> allProducts = mapper.convertValue(allProductsResponse.getData(), new TypeReference<List<ProductResponse>>() {
        });

        ResponseModel<ProductResponse> productByIdResponse = testRestTemplate.getForObject("/api/v1/product/1", ResponseModel.class);
        ProductResponse productById = mapper.convertValue(productByIdResponse.getData(), new TypeReference<ProductResponse>() {
        });

        ResponseModel<Basket> createBasketResponse = testRestTemplate.postForObject("/api/v1/basket", createBasketRequest, ResponseModel.class);
        Basket createBasket = mapper.convertValue(createBasketResponse.getData(), new TypeReference<Basket>() {
        });

        ResponseModel<GetBasketResponse> getBasketResponse = testRestTemplate.getForObject("/api/v1/basket/1", ResponseModel.class);
        GetBasketResponse getBasket = mapper.convertValue(getBasketResponse.getData(), new TypeReference<GetBasketResponse>() {
        });

        ResponseModel<GetUserResponse> getUserResponse = testRestTemplate.getForObject("/api/v1/user/1", ResponseModel.class);
        GetUserResponse getUser = mapper.convertValue(getUserResponse.getData(), new TypeReference<GetUserResponse>() {
        });

        ResponseModel<OrderTransaction> createOrderResponse = testRestTemplate.postForObject("/api/v1/order/confirm", orderConfirmRequest, ResponseModel.class);
        OrderTransaction createOrder = mapper.convertValue(createOrderResponse.getData(), new TypeReference<OrderTransaction>() {
        });

        // Assert
        assertEquals("success", allProductsResponse.getMessage());
        assertEquals("success", productByIdResponse.getMessage());
        assertEquals("success", createBasketResponse.getMessage());
        assertEquals("success", getBasketResponse.getMessage());
        assertEquals("success", getUserResponse.getMessage());
        assertEquals("success", createOrderResponse.getMessage());

        assertTrue(allProducts.size() > 0);
        assertEquals(1,productById.getId());
        assertEquals(1,createBasket.getUserId());
        assertEquals(1,getBasket.getUserId());
        assertEquals(1,getUser.getId());
        assertEquals(1,createOrder.getUserId());
    }
}
