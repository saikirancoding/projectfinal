package com.symbiosis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.symbiosis.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

	Product findByName(String name);
	
	
	@Query("select case when count(s)>0 then true else false end from Product s where s.id =?1")
	Boolean isProductExitsById(Integer id);
}
