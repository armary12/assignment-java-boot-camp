package com.example.ecommerce.basket.services;

import com.example.ecommerce.basket.exceptions.BasketNotFoundException;
import com.example.ecommerce.basket.models.BasketItem;
import com.example.ecommerce.basket.models.CreateBasketRequest;
import com.example.ecommerce.basket.models.GetBasketResponse;
import com.example.ecommerce.basket.repositories.BasketRepository;
import com.example.ecommerce.basket.repositories.entities.Basket;
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
        basket.setBasketItems(request.getBasketItems());
        basket.setTotalPrice(Arrays.stream(request.getBasketItems()).mapToInt(e -> e.getNetPrice() * e.getProductQuantity()).sum());
        basket.setTotalQuantity(Arrays.stream(request.getBasketItems()).mapToInt(BasketItem::getProductQuantity).sum());
        basket.setCreatedDate(new Date());
        Basket basketResponse = basketRepository.save(basket);
        return basketResponse;
    }

    public GetBasketResponse getBasket(int userId) {
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
        return basketResponse;
    }

    public void setBasketRepository(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }
}
