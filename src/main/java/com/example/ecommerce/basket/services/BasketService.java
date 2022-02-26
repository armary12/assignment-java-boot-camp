package com.example.ecommerce.basket.services;

import com.example.ecommerce.basket.models.BasketItem;
import com.example.ecommerce.basket.models.CreateBasketRequest;
import com.example.ecommerce.basket.models.GetBasketResponse;
import com.example.ecommerce.basket.repositories.BasketRepository;
import com.example.ecommerce.basket.repositories.entities.Basket;
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

    public Basket createBasket(CreateBasketRequest request) {
        Basket basket = new Basket();
        basket.setUserId(request.getUserId());
        basket.setBasketItem(request.getBasketItems());
        basket.setTotalPrice(Arrays.stream(request.getBasketItems()).mapToInt(e->e.getNetPrice() * e.getProductPrice()).sum());
        basket.setTotalQuantity(Arrays.stream(request.getBasketItems()).mapToInt(BasketItem::getProductQuantity).sum());
        basket.setCreatedDate(new Date());

        return basketRepository.save(basket);
    }

    public GetBasketResponse getBasket(int userId) {
        Optional<Basket> basketOptional = basketRepository.findByUserId(userId);
        if (basketOptional.isEmpty()){
            throw new BasketNotFoundException("Basket not found");
        }
        Basket basket = basketOptional.get();
        GetBasketResponse basketResponse = new GetBasketResponse();
        basketResponse.setId(basket.getId());
        basketResponse.setUserId(basket.getUserId());
        basketResponse.setBasketItems(basket.getBasketItem());
        basketResponse.setTotalPrice(basket.getTotalPrice());
        basketResponse.setTotalQuantity(basket.getTotalQuantity());
        return basketResponse;
    }
}
