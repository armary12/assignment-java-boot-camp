package com.example.ecommerce.basket.services;

import com.example.ecommerce.basket.exceptions.BasketNotFoundException;
import com.example.ecommerce.basket.models.BasketItem;
import com.example.ecommerce.basket.models.CreateBasketRequest;
import com.example.ecommerce.basket.models.GetBasketResponse;
import com.example.ecommerce.basket.repositories.BasketRepository;
import com.example.ecommerce.basket.repositories.entities.Basket;
import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.order.repositories.entities.OrderTransaction;
import com.example.ecommerce.product.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    public ResponseModel<Basket> createBasket(CreateBasketRequest request) {
        Basket basket = new Basket();
        basket.setUserId(request.getUserId());
        basket.setBasketItems(request.getBasketItems());
        basket.setTotalPrice(Arrays.stream(request.getBasketItems()).mapToInt(e -> e.getNetPrice() * e.getProductQuantity()).sum());
        basket.setTotalQuantity(Arrays.stream(request.getBasketItems()).mapToInt(BasketItem::getProductQuantity).sum());
        basket.setCreatedDate(new Date());
        Basket basketResponse = basketRepository.save(basket);

        ResponseModel<Basket> response = new ResponseModel();
        response.setData(basketResponse);
        return response;
    }

    public ResponseModel<GetBasketResponse> getBasket(int userId) {
        Optional<Basket> basketOptional = basketRepository.findByUserId(userId);
        if (basketOptional.isEmpty()) {
            throw new BasketNotFoundException("Basket not found");
        }
        Basket basket = basketOptional.get();
        GetBasketResponse basketResponse = new GetBasketResponse();
        basketResponse.setId(basket.getId());
        basketResponse.setUserId(basket.getUserId());
        basketResponse.setBasketItems(basket.getBasketItems());
        basketResponse.setTotalPrice(basket.getTotalPrice());
        basketResponse.setTotalQuantity(basket.getTotalQuantity());

        ResponseModel<GetBasketResponse> response = new ResponseModel();
        response.setData(basketResponse);
        return response;
    }
}
