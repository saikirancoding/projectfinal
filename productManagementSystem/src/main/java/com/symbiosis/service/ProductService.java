package com.symbiosis.service;

import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.web.multipart.MultipartFile;

import com.symbiosis.model.Product;

public interface ProductService {

	 public void getProductByIdImage(int id);
	 public Product storeFile(MultipartFile file) ;
	Product saveProduct(Product product);
	Product getProductByName(String name);
	Product getProductById(int id);
	List<Product> saveProducts(List<Product> products);
    List<Product> getProducts();
    String deleteProduct(int id);
    Product updateProduct(Product product);
}
