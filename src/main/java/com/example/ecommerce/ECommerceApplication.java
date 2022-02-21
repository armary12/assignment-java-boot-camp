package com.example.ecommerce;

import com.example.ecommerce.product.repositories.BrandRepository;
import com.example.ecommerce.product.repositories.ProductRepository;
import com.example.ecommerce.product.repositories.entities.Brand;
import com.example.ecommerce.product.repositories.entities.Product;
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

	@PostConstruct
	public void initializeData() {
		Brand brand1 = new Brand(1, "Sneaker club","ร้านขายรองเท้า","","","ACTIVE",new Date(),null);
		brandRepository.save((brand1));

		Product product1 = new Product(1, "Adidas Yeezy Boost 350 V2 Beluga 2.0(AH2203)", "สวมใส่สะบาย",39900,28,"2022-10-10",0,1,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null);
		productRepository.save((product1));

	}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
}
