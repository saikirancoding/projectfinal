package com.symbiosis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.symbiosis.model.Product;
import com.symbiosis.service.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl proService;
	
	//error
	
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		
		proService.storeFile(file);
		
		return ResponseEntity.ok("working");
		
	}
	
	
	
	
	/*
	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		return proService.saveProduct(product);
	}
	*/
	
	
	/*
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		
		Product p= proService.saveProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED)
				.header("Add", "Product created").body(p);
	}
	*/
	@GetMapping("/{name}")
	public Product findProductByName(@PathVariable String name)
	{
		return proService.getProductByName(name);
	}
	
	@GetMapping("/downloadfile/{id}")
	public void DownloadFile(@PathVariable int id)
	{
		 proService.getProductByIdImage(id);
	}
	
	@GetMapping("/product/{id}")
    public Product findProductById(@PathVariable int id) {
        return proService.getProductById(id);
    }
	
	  @PostMapping("/addProducts")
	    public List<Product> addProducts(@RequestBody List<Product> products) {
	        return proService.saveProducts(products);
	    }
	  
	
	  
	  @DeleteMapping("/delete/{id}")
	  public String delProduct(@PathVariable int id) {
		  
		 return proService.deleteProduct(id);
		  
	  }
	  
	  @PutMapping("/update")
	    public Product updateProduct(@RequestBody Product product) {
	        return proService.updateProduct(product);
	    }
	  
	  
}
