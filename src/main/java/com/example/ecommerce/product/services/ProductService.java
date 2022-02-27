package com.example.ecommerce.product.services;

import com.example.ecommerce.common.model.ResponseModel;
import com.example.ecommerce.product.exceptions.ProductNotFoundException;
import com.example.ecommerce.product.models.ProductResponse;
import com.example.ecommerce.product.repositories.ProductRepository;
import com.example.ecommerce.product.repositories.entities.Product;
import com.example.ecommerce.product.repositories.entities.ProductReview;
import com.example.ecommerce.user.models.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ResponseModel<ProductResponse> getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new ProductNotFoundException("Product not found");
        }
        ProductResponse productResponse = mapProductResponse(product.get());

        ResponseModel<ProductResponse> response = new ResponseModel();
        response.setData(productResponse);
        return response;
    }

    public ResponseModel<List<ProductResponse>> getProducts(String search) {
        List<Product> products;
        if (search != null && !search.isEmpty()){
            products = productRepository.findByNameContaining(search);
        } else {
            products = productRepository.findAll();
        }
        List<ProductResponse> productsResponse = products.stream().map(e -> mapProductResponse(e)).collect(Collectors.toList());

        ResponseModel<List<ProductResponse>> response = new ResponseModel();
        response.setData(productsResponse);
        return response;
    }


    private ProductResponse mapProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        productResponse.setDiscountPercent(product.getDiscountPercent());
        productResponse.setNetPrice(product.getPrice() - (product.getDiscountPercent() * product.getPrice())/100);
        productResponse.setPromotionEndDate(product.getPromotionEndDate());
        productResponse.setIsDeliveryDiscount(product.getIsDeliveryDiscount());
        productResponse.setProductModelName(product.getProductModel().getName());
        productResponse.setPrimaryImage(product.getPrimaryImage());
        productResponse.setSecondaryImages(product.getSecondaryImages());
        productResponse.setBrandName(product.getBrand().getName());
        productResponse.setShopName(product.getShop().getName());
        productResponse.setShopProvince(product.getShop().getProvince());
        productResponse.setStatus(product.getStatus());
        productResponse.setSizes(product.getSizes());
        productResponse.setReviewerCount(product.getProductReviews().size());
        productResponse.setScore(calculateReviewScore(product.getProductReviews()));
        return productResponse;
    }

    private int calculateReviewScore(List<ProductReview> productReviews) {
        if (productReviews.size() == 0) {
            return 0;
        }
        return productReviews.stream().mapToInt(e -> e.getScore()).sum()/productReviews.size();
    }
}
