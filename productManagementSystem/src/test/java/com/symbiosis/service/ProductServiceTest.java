package com.symbiosis.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.symbiosis.dao.ProductRepository;
import com.symbiosis.model.Product;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@Mock
	ProductRepository productRepo;
	
	ProductServiceImpl productService;

	@BeforeEach
	void setUp() {
		this.productService = new ProductServiceImpl();
		this.productService.setProdRepo(productRepo);
	}
	
	@Test
	void testSaveProduct() {
		Product p=new Product(123,"Colgate",2,100);
		productService.saveProduct(p);
//		Mockito.verify(productRepo).findAll();
		Mockito.verify(productRepo).save(p);
	}

}
