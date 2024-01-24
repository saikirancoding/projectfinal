package com.symbiosis.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.symbiosis.dao.ProductRepository;
import com.symbiosis.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository prodRepo;
	
	
	@Override
	public Product storeFile(MultipartFile file) {
		try {
			InputStream is=file.getInputStream();
			byte[] data=new byte[is.available()];
			
			is.read(data);
			Product product=new Product();
			product.setId(12);
			product.setName("laptop");
			product.setPrice(30);
			product.setQuantity(2);
			product.setImage(data);
			
			prodRepo.save(product);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ProductRepository getProdRepo() {
		return prodRepo;
	}

	public void setProdRepo(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}

	@Override
	public Product saveProduct(Product product) {
		
		return prodRepo.save(product);
	}

	@Override
	public Product getProductByName(String name) {
		
		return prodRepo.findByName(name);
	}

	public Product getProductById(int id) {
        return prodRepo.findById(id).orElse(null);
    }
	
	
	public List<Product> saveProducts(List<Product> products) {
        return prodRepo.saveAll(products);
    }

	
    public List<Product> getProducts() {
        return prodRepo.findAll();
    }
   
    public String deleteProduct(int id) {
    	prodRepo.deleteById(id);
        return "product removed !! " + id;
    }
    
    public void getProductByIdImage(int id) {
        Product product= prodRepo.findById(id).orElse(null);
      byte b[]=  product.getImage();
     try {
      FileOutputStream fout=new FileOutputStream("C:/Users/kiran/OneDrive/Desktop/SaveImg/retrive.jpeg");  
		fout.write(b); 
     }catch(Exception e) {e.printStackTrace();}
		

    }

    public Product updateProduct(Product product) {
        Product existingProduct = prodRepo.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
       // existingProduct.setQuantity(product.getQuantity());
      //  existingProduct.setPrice(product.getPrice());
        return prodRepo.save(existingProduct);
    }

	

	
}
