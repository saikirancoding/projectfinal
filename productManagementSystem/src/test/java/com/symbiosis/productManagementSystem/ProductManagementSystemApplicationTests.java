package com.symbiosis.productManagementSystem;

 import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductManagementSystemApplicationTests {

	private Calculator calculator=new Calculator();
	
	@Test
	void contextLoads() {
	}

	@Test
	void testSum()
	{
		int expectedResult=9;
		
		int actualResult=calculator.doSum(2, 4, 4);
		
	
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	
	
	
	@Test
	void testProduct()
	{
		int expectedResult=9;
		int actualResult=calculator.doProduct(2, 3);
		
		assertThat(actualResult).isEqualTo(expectedResult);
	}
	
	
	@Test

	void testCompareNums()
	{
		Boolean actualResult=calculator.compareTwoNums(3, 3);
		assertThat(actualResult).isTrue();
	
	}
}
