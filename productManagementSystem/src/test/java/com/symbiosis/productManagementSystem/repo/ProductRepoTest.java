package com.symbiosis.productManagementSystem.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.symbiosis.dao.ProductRepository;
import com.symbiosis.model.Product;

@SpringBootTest   
public class ProductRepoTest {

	@Autowired
	ProductRepository productRepository;
	
	@Test
	void isProductExitsById()
	{
		Product p=new Product(123,"Colgate",2,100);
		productRepository.save(p);
		
		Boolean actualResult=productRepository.isProductExitsById(123);
		assertThat(actualResult).isTrue();
	}
}
