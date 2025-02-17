package com.example.ecommerce;

import com.example.ecommerce.product.repositories.*;
import com.example.ecommerce.product.repositories.entities.*;
import com.example.ecommerce.user.repositories.UserRepository;
import com.example.ecommerce.user.repositories.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	@Autowired
	ProductReviewRepository productReviewRepository;
	@Autowired
	UserRepository userRepository;



	@PostConstruct
	public void initializeData() {
		List<User> userList = new ArrayList<>();
		userList.add(new User(1, "Chonlatid", "Jitbute","MALE","16 Charoemprakiet Rama 9 45 yak 2 Nongbon Pravet Bangkok", "10250", "16 Charoemprakiet Rama 9 45 yak 2 Nongbon Pravet Bangkok","10250","0987654321","chonlaird.jit@gmail.com",1,"ACTIVE",new Date(), null));
		userRepository.saveAll(userList);

		List<Brand> brandList = new ArrayList<>();
		brandList.add(new Brand(1, "ADIDAS","","","","ACTIVE",new Date(),null));
		brandList.add(new Brand(2, "POCA","","","","ACTIVE",new Date(),null));
		brandRepository.saveAll(brandList);

		List<Shop> shopList = new ArrayList<>();
		shopList.add(new Shop(1, "Sneaker shop","","ระยอง","","","ACTIVE",new Date(),null));
		shopList.add(new Shop(2, "สุภาพุรุษ จาก Poca Shoes","","สมุทรปราการ","","","ACTIVE",new Date(),null));
		shopRepository.saveAll(shopList);

		List<ProductModel> productModelList = new ArrayList<>();
		productModelList.add(new ProductModel(1, "Beluga","ACTIVE",new Date(),null));
		productModelList.add(new ProductModel(2, "Pimeknit Core","ACTIVE",new Date(),null));
		productModelList.add(new ProductModel(3, "PK Japan Triple","ACTIVE",new Date(),null));
		productModelList.add(new ProductModel(4, "Sneakers Fashion","ACTIVE",new Date(),null));
		productModelList.add(new ProductModel(5, "Color Core Black/Icey","ACTIVE",new Date(),null));
		productModelRepository.saveAll(productModelList);

		List<ProductReview> productReviewList = new ArrayList<>();
		productReviewList.add(new ProductReview(4, 5, "ดีมากครับ","ACTIVE",new Date(),null));
		productReviewList.add(new ProductReview(4, 3, "ใช้งานได้ดี","ACTIVE",new Date(),null));
		productReviewRepository.saveAll(productReviewList);

		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1,"Adidas Yeezy Boost 350 V2 Beluga 2.0(AH2203)", "สวมใส่สะบาย",39900,28,"2022-10-10",0,1,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null, new String[]{"36","37","38"}));
		productList.add(new Product(2,"Adidas NMD R1 Pimeknit Core Black", "นุ่มลื่น เป็นมิตร",15000,34,"2022-10-10",0,2,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null, new String[]{"36","37","40"}));
		productList.add(new Product(3,"Adidas NMD R1 PK Japan Triple Black", "สวมใส่สะบาย",15000,14,"2022-10-10",0,3,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null, new String[]{"38","39","40"}));
		productList.add(new Product(4,"POCA SHOE NMD Sneakers Fashion รองเท้า ลำลอง ผ้าใบ", "สวมใส่สะบาย",1900,79,"2022-10-10",1,4,1,"test1", new String[]{"test"},2,2,"ACTIVE",new Date(),null, new String[]{"36","37","38"}));
		productList.add(new Product(5,"Adidas NMD R1 Color Core Black/Icey Blue", "สวมใส่สะบาย",12000,33,"2022-10-10",0,5,1,"test1", new String[]{"test"},1,1,"ACTIVE",new Date(),null, new String[]{"36","37","38"}));
		productRepository.saveAll(productList);
	}

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}
}
