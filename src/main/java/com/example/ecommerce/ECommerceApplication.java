package com.example.ecommerce;

import com.example.ecommerce.product.repositories.BrandRepository;
import com.example.ecommerce.product.repositories.ProductModelRepository;
import com.example.ecommerce.product.repositories.ProductRepository;
import com.example.ecommerce.product.repositories.ShopRepository;
import com.example.ecommerce.product.repositories.entities.Brand;
import com.example.ecommerce.product.repositories.entities.Product;
import com.example.ecommerce.product.repositories.entities.ProductModel;
import com.example.ecommerce.product.repositories.entities.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Date;

@SpringBootApplication
public class ECommerceApplication {


	@Autowired
	ProductRepository productRepository;
	@Autowired
	BrandRepository brandRepository;
	@Autowired
	ShopRepository shopRepository;
	@Autowired
	ProductModelRepository productModelRepository;

	@PostConstruct
	public void initializeData() {
		Brand brand1 = new Brand(1, "ADIDAS","","","","ACTIVE",new Date(),null);
		brandRepository.save(brand1);

		Shop shop1 = new Shop(1, "Sneaker shop","","ระยอง","","","ACTIVE",new Date(),null);
		shopRepository.save(shop1);

		ProductModel productModel1 = new ProductModel(1, "Yeezy Boost 350","ACTIVE",new Date(),null);
		productModelRepository.save(productModel1);

		Product product1 = new Product(1, "Adidas Yeezy Boost 350 V2 Beluga 2.0(AH2203)", "สวมใส่สะบาย",39900,28,"2022-10-10",0,1,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null, new String[]{"36","37","38"});
		productRepository.save(product1);
	}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
}
